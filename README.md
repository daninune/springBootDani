Structure

Interfaz:
Thymeleaf

DTO:
Conversión y traduccion de datos entre interfaz y controlador.

Controlador:
(@Controller)
Solo cargamos datos para llamar a vista y llamamos a las vistas.

Servicio:
(@Service)
Provee los datos al controlador.
No accede directamente a los datos. Toma los datos del DAO y tiene lógica para ofrecer lo que se necesita para el controlador y la vista. (como nuestro viejo controlador en php mas o menos)

DAO
(@Repository)
Usa la entity para mapear el objeto en BD. Además tiene consutas concretas, sea con @Query o con  Criteria Builder (https://www.baeldung.com/spring-data-criteria-queries). Sirve de puente para los métodos get y set de la entity.

Modelo (o entidad)
Hace de espejo y mapea la tabla de BD. Tiene acceso a los datos en forma de getters y setters.





### Nota importante sobre el patrón DAO 20/12/2022
Existen 3 tipos de consultas a tener en cuenta en el patrón DAO:
- **Generales**:   
   Son las que se generan automáticamente a partir de importar interfaces de repositorios como CRUDRepository o JpaRepository.
   Por ejemplo, ```findAll()``` o ```findById()```.  
  

 - **Básicas**   
    Podemos personalizarlas y se diferencian de las *Generales* por un parámetro, campo o estado muy concreto de la propia entidad. Ejemplo:
    ```java
    @Query("SELECT * FROM Employee e WHERE e.idemployee = ?1 and e.status = 1")
    public Employee findActiveEmployeesById(int id);
    ```  
 - **Personalizadas**:  
   Son las más complejas. Pueden llevar JOINs de otras columnas. 
   Se pueden hacer con @Query o con Criteria Builder.
  
    Ejemplo con @Query:
    ```java
    @Query("SELECT u FROM User u INNER JOIN u.address a INNER JOIN u.roles r WHERE a.city = ?1 AND r.name = ?2")
    List<User> findByCityAndRole(String city, String role);
    ```
    con Criteria Builder:
    ```java
    public List<User> findByCityAndRole(String city, String role) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> user = cq.from(User.class);
        Join<User, Address> address = user.join("address");
        Join<User, Role> role = user.join("roles");
        cq.select(user).where(cb.equal(address.get("city"), city), cb.equal(role.get("name"), role));
        return em.createQuery(cq).getResultList();
    }
    ```
  
Para la estructura de nuestras clases y métodos DAO, podemos seguir el siguiente patrón:

- **EntidadDaoImpl** - Implementa *EntidadDao*. 
Habilita los métodos generales y define los métodos básicos que necesitemos.  
  

- **EntidadDaoCustomImpl** - Implementa *EntidadDaoCustom*. Define consultas personalizadas.
  
  
  
  


  
  
  
  
