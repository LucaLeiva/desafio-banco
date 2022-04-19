# desafio-banco
Este desafio es una API-Rest hecha en Java con Spring-Boot, Spring Security (con HttpBasic) y MySQL, para cargar productos y tener usuarios. No utilize la ruta solicitada por el desafio porque si no todas las clases iban a estar mezcladas y seria muy ilegible con la cantidad existente, los separe segun su funcionalidad (Controladores, Servicios, etc).  

Para ejecutar este proyecto hace falta tener Java 11 o superior y MySQL instalados. Las dependencias se añaden con Maven. Probablemente sea necesario cambiar la ruta de la conexion y de Usuario y Contraseña de la Base de Datos, desde el archivo aplication.propierties. Pero lo que si es necesario crear al menos 1 usuario directamente en la Base de Datos:  
&emsp; -No es necesario ingresar el id (porque es autogenerado)  
&emsp; -La contraseña que se quiera registrar se debe generar aca https://bcrypt-generator.com/ y guardarse de forma codificada  
&emsp; -Username puede ser cualquiera  
  
Al ejecutar la aplicacion se debe ingresar el usuario y la contraseña SIN CODIFICAR (es decir, si mi contraseña es 1234, yo guardo en la base de datos $2a$12$VP5oxZA1UsHON1kMNGEdL.WjeGHpG9gaKPls2MGwqvEfVO7au2cfe y al ingresar el usuario pongo 1234)  

No es necesaria ninguna otra consideracion.
