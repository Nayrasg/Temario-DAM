Vamos a realizar nuestro propio programa de cifrado de mensajería. Nuestra empresa dispone de dos sedes, en diferentes partes del mundo. A la hora de comunicarnos vía mail de una sede a otra, utilizaremos el sistema mail. Pero la identificación, o envío incorrecto de alguno de los correos supondría la revelación de secretos de nuestra empresa. Por ello vamos a realizar un programa que cifre nuestro texto en uno ilegible, para que estemos seguros mientras nuestro mensaje circula por la red.

Cifrado

Desarrolla la función cifrar, la cual recibirá un texto, lo pasará por una clave, y nos devolverá nuestro texto cifrado.


Clave

Desarrolla la función clave. Que a partir de una letra desvolverá otra, en base a una estrategia de cifrado. Comenta el tipo de clave que has escogido.

https://techlandia.com/convertir-caracteres-codigos-ascii-java-como_450085/


Descifrado

Desarrolla la función descifrar, que a partir de un texto cifrado, pasará el texto por una clave, y nos devolverá el texto de manera leíble.


Menú principal

Desarrolla un menú principal que pruebe las funciones anteriores, y muestre el código antes de cifrar, el código cifrado, y el código después de ser descifrado.


Para el ejercicio he elegido el método de cifrado de César: cada letra se sustituye por otra letra que se encuentra N posiciones adelante en el abecedario. Se considera que la letra siguiente a la ‘z’ es la ‘a’.
Para descifrar un texto se realiza la operación contraria con N posiciones por detrás en el alfabeto. 
