# Pizarra

Catalina Bravo Hernandez

Enunciado

Se debe crear una pizarra múltiple que permita dibujar trazos, rectángulos, y conectores UML con mouseDrag. La pizarra debe modos de edición tales como borrar, y crear las diferentes formas de UML. Para eliminar se busca el elemento que contenga los pixeles encerrados por un rectángulo fantasma que queda entre mousePress y mouseRelease. La pizarra múltiple consiste en tener en el panel central una de ellas a la vez, pudiendo cambiar de una a otra sin perder lo editado. Se debe poder grabar en archivo la pizarra múltiple y cargarla de este. se debe poder borrar la pizarra completa. La pizarra múltiple se debe grabar en el archivo automáticamente al cambiar de una pizarra a otra. Se debe poder elegir el color de las líneas mediante botones GUI.

14/12
Se propone crear la pizarra múltiple.
Creando un arreglo de pizarras, para ir iterando a través de ellas y conseguir tener varias pizarras a la vez.
Agregando la función de añadir pizarra, siguiente pizarra, anterior pizarra y quitar pizarra.
Creando la opción en la barra de Menu.

Se logra crear Pizarra multiple con problemas, la primera pizarra no se puede eliminar y algunos problemas con la iteración.

*Se propone para mañana:
-Arreglar el problema con el lapiz y añadirle colores.
-Averiguar como agregar texto y un cuadro UML a la vez.
-Arrglar el boton limpiar para que funcione con todas las pizarras.

15/12
Solucionado problema con el lapiz, ahora se mantiene con otros objetos y en cada pizarra.
