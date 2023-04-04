Usa la pagina start.spring.io para la estructura inicial

No estais usando PostMapping, ni DeleteMapping.
No estais usando PathVariables, ejemplo de uso:

@GetMapping("/jpa/users/{username}")
public User getUser( @PathVariable String username ){
    // Aquí puedes usar la variable username directamente, lo cual es muy útil
    // Ejemplo:

    return getUserByUsername(username)
}

Para pillar más de una variable, se declaran así:
@GetMapping("/jpa/users/{username}/dni/{numero)")
public User getUser( @PathVariable String username, @PathVariable long id ){
}

Toda la parte de Security para el login
Usa JWT (Json Web Token) para manejar la parte de info privada