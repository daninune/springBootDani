# --volcado de  datos  daninune 09/02/2023

-- Volcando datos para la tabla demospring.permissions: ~11 rows (aproximadamente)
DELETE
FROM `permissions`;
INSERT INTO `permissions` (`id`, `name`)
VALUES (1, 'CREATE'),
       (2, 'READ'),
       (3, 'UPDATE'),
       (4, 'DELETE'),
       (5, 'ONLY_RRHH'),
       (6, 'ONLY_RRHH_VACATION'),
       (7, 'ONLY_RRHH_VACATION_HISTORICAL'),
       (8, 'ONLY_RRHH_TIMETRACK'),
       (9, 'ONLY_USER'),
       (10, 'ONLY_MODERATOR'),
       (11, 'ONLY_ADMIN');

-- Volcando datos para la tabla demospring.roles: ~11 rows (aproximadamente)
DELETE
FROM `roles`;
INSERT INTO `roles` (`id`, `name`)
VALUES (1, 'ROLE_USER'),
       (2, 'ROLE_MODERATOR'),
       (3, 'ROLE_ADMIN'),
       (4, 'ROLE_RRHH_CONSULTANT'),
       (5, 'ROLE_RRHH_CONSULTANT_VACATION'),
       (6, 'ROLE_RRHH_CONSULTANT_VACATION_HISTORICAL'),
       (7, 'ROLE_RRHH_CONSULTANT_TIMETRACK'),
       (8, 'ROLE_RRHH_MANAGER'),
       (9, 'ROLE_RRHH_MANAGER_VACATION'),
       (10, 'ROLE_RRHH_MANAGER_VACATION_HISTORICAL'),
       (11, 'ROLE_RRHH_MANAGER_TIMETRACK');


-- Volcando datos para la tabla demospring.users: ~12 rows (aproximadamente)
DELETE
FROM `users`;
INSERT INTO `users` (`id`, `email`, `password`, `username`)
VALUES (1, 'javier.garcia@demo.com', '$2a$10$QBPuy4hqwGkaPm6L0m5OieNCUKjaV5kkeXpdKtEN38fGQiDAxaCHq', 'javier.garcia'),
       (2, 'javier.gandara@demo.com', '$2a$10$l/Fv9cJsKVH.zytS9ca1seseBUC4NtO4fQWdwe8Tx57BvFAcZQPPK', 'javier.gandara'),
       (3, 'daniel.baladez@demo.com', '$2a$10$CFXYf5XADmas2vMLBIMhgu0h0GAiIy3ofOL3te0htWkOx0IAtPSsm', 'daniel.baladez'),
       (4, 'santi.vazquez@demo.com', '$2a$10$fc31UQFqP5hEvYYLDlPCGe.CREh2cClhRGm0KsBIO97T1FlA4mWuy', 'santi.vazquez'),
       (5, 'consultant@demo.com', '$2a$10$Zj4LA9RZXg9pAhn4NbqQ0O4AyRs6jxcFFcq50Bu8Ae38DFQrrFRf2', 'consultant'),
       (6, 'consultantV@demo.com', '$2a$10$h0lDJ56aAVg9ysrNxu5.OePmgFN7loZoBBEQdXv18bz/PYpBNbd7C', 'consultantV'),
       (7, 'consultantTT@demo.com', '$2a$10$6Q.KIBY2RBnv0lI/BQTUveOzTMVywk15s27cPafRzfCusTRdHZVsu', 'consultantTT'),
       (8, 'consultantVH@demo.com', '$2a$10$7hompttQXa.XXB1mDBHTiu3JOxRUKWga.WKi3Vly/.NV4Q383TvVO', 'consultantVH'),
       (9, 'manager@demo.com', '$2a$10$KOdSizq.f2.Oz3LTc3cnx.nsxRMQg5pw1zLIUuprwCOGyObC4PFtW', 'manager'),
       (10, 'managerV@demo.com', '$2a$10$O3NrPm1wZr2Wx5axCvOFJeOc2.SW5WBC0g/LuppDjkmuc9d/MEBeS', 'managerV'),
       (11, 'managerTT@demo.com', '$2a$10$jwKZSHNbEco5rKTFb8nZie/riQI8JdFjYVLlbd/BPoNi/O.TiM55q', 'managerTT'),
       (12, 'managerVH@demo.com', '$2a$10$xMtrSj2OZKXaCI6n5BKhX.ufQ0EuWcjRWRlE2OePnkD1sOx59QqM6', 'managerVH');

-- Volcando datos para la tabla demospring.user_roles: ~24 rows (aproximadamente)

DELETE
FROM `user_roles`;
INSERT INTO `user_roles` (`user_id`, `role_id`)
VALUES (1, 1),
       (2, 1),
       (3, 1),
       (4, 1),
       (5, 1),
       (6, 1),
       (7, 1),
       (8, 1),
       (9, 1),
       (10, 1),
       (11, 1),
       (12, 1),
       (1, 2),
       (2, 2),
       (3, 2),
       (4, 2),
       (5, 2),
       (6, 2),
       (7, 2),
       (8, 2),
       (9, 2),
       (10, 2),
       (11, 2),
       (12, 2);

DELETE
FROM `area`;
INSERT INTO `area` (`id`, area.`nombre`)
VALUES (1, 'Software Factory'),
       (2, 'Testing');

DELETE
FROM `project`;
INSERT INTO `project` (`id`, project.`computable`, project.`name`)
VALUES (1, true, 'TestProyecto01'),
       (2, false, 'TestProyecto02');

DELETE
FROM `project`;
INSERT INTO `project` (`id`, project.computable, project.name)
VALUES (1, true, 'proyecto 1'),
       (2, true, 'proyecto 2');


--- añadir un empleado

INSERT INTO employees (address, alreadyVoted, area, baseline, category, city, country, creationdate, email, fechaNacimiento, firstlogin, hash, iban, id, idcard, idcustomer, idoffice, idprovince, idrol, idschedule, isdelete, job, lastname, leavingdate, loginretries, name, nip, notes, pass, passreset, passresetdate, rgpd, ssnumber, startdate, tel, vacationLimit, zip)
VALUES ('Calle Falsa 123', 0, 'Desarrollo', 'A', 'Junior', 'Madrid', 'España', '2022-01-01 00:00:00.000000', 'juan.perez@email.com', '1995-01-10', 0, '1a2b3c4d', 'ES123456789012345678', 1, '12345678A', 1, 1, 1, 1, 1, 0, 'Desarrollador', 'Pérez', NULL, 0, 'Juan', '111', 'equipo 1 proyecto x', 'mypassword', NULL, NULL, 'Aceptado', '280155501', '2022-01-01', '+34 600 111 222', '30', '28001');

