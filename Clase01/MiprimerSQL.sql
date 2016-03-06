
CREATE USER demo IDENTIFIED BY admin;

GRANT CONNECT,RESOURCE,UNLIMITED TABLESPACE TO demo; /* Creaciòn de la tabla */
/* Se confirgura en un tablespace de espacion ilimitado. */

create table mensaje (
	de varchar2(20), /* El tipo de dato en Oracle para var char es varchar2 */
	para varchar2(20),
	texto varchar2(200)
);

insert into mensaje values('profe', 'estudiantes', 'Que les parece el curso?');