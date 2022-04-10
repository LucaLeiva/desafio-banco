# desafio-banco

Este desafio es para el Nuevo Banco del Chaco, es una API-Rest hecha en Java con Spring-Boot, Spring Security (con HttpBasic) y MySQL. No utilize la ruta solicitada por el desafio porque si no todas las clases iban a estar mezcladas e iba a ser muy ilegible todas las clases existentes, los separe segun su dominio.
Para ejecutar este proyecto hace falta tener Java 11 o superior, y MySQL instalado. Las dependencias se añaden con Maven. Pero es necesario crear al menos 1 usuario directamente en la Base de Datos:

  -no es necesario ingresar el id (porque es autogenerado) 
  
  -la contraseña que se quiera registrar se debe generar aca https://bcrypt-generator.com/ y guardarse de forma codificada
  
  -username cualquiera
  
  
Al ejecutar se debe ingresar el usuario y la contraseña SIN CODIFICAR (es decir, si mi contraseña es 1234, yo guardo en la base de datos $2a$12$VP5oxZA1UsHON1kMNGEdL.WjeGHpG9gaKPls2MGwqvEfVO7au2cfe y al ingresar el usuario ingreso 1234).

No es necesario ninguna otra consideracion.
