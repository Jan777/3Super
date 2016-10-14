# Historias de Usuario y Criterios de aceptación

* Como jugador, quiero crear mi personaje, editando sus características principales (como raza y casta) para verme reflejado en mi avatar.
  * Dado un **Personaje**, quiero poder escoger una las siguientes razas: **Humano**, **Holograma** y **BOT**.
  * Dado un **Personaje**, quiero tener las siguientes habilidades: **Fuerza**, **Energía** e **Ingenio**.
  * Dado un **Humano**, quiero poder escoger una de las siguientes castas: **Programador**, **Tester** y **Soporte**.
  * Dado un **Holograma**, quiero poder escoger una de las siguientes castas: **Programador**, **Tester** y **Soporte**.
  * Dado un **BOT**, quiero poder escoger una de las siguientes castas: **Programador**, **Tester** y **Soporte**.
  * Dado una **Raza**, quiero poseer puntos de atributo distribuidos de una forma distinta a las demás **Razas**.
  * Dado una **Casta**, quiero poseer skills que me distingan de las otras **Castas**.

* Como jugador, quiero ingresar a un mundo para adquirir experiencia, items, y habilidades nuevas.
  * Dado un **Jugador**, quiero poder elegir un nickname para identificarme en el juego y distinguirme de los demás jugadores.
  * Dado un **Jugador**, quiero poder establecer una contraseña que permita ingresar a mi cuenta.
  * Dado un **Personaje**, quiero poder elegir un mundo en el cual ingresar.
  * Dado un **Personaje**, no debo poder atravesar obstaculos ni otros jugadores.
  * Dado un **Personaje**, no debo poder salir de los límites del mapa.

* Como jugador, quiero eliminar enemigos para aumentar mi experiencia.
  * Dado un **Personaje**, quiero eliminar **NPCs** para poder aumentar mi nivel de experiencia.
  * Dado un **Personaje**, quiero eliminar **Personajes enemigos** para aumentar mi nivel de experiencia.
  * Dado un **Personaje**, no quiero perder experiencia si me matan en combate.
  * Dado un **Personaje**, quiero droppear mi mejor item si me matan en combate con un **Jugador enemigo** o **Alianza enemiga**.
 
* Como jugador, quiero acumular experiencia para poder subir de nivel.
  * Dado un **Personaje**, quiero subir de nivel cuando haya obtenido una cierta cantidad de experiencia.
  * Dado un **Nivel de experiencia**, quiero que este requiera mas cantidad de puntos de experiencia en cada nivel superior.
  * Dado un **Nivel de experiencia**, quiero que el máximo de este sea el nivel 50.
  
* Como jugador, quiero subir de nivel para poder asignar puntos adicionales a mis habilidades.
  * Dado un **Personaje**, quiero poder distribuir mis puntos de habilidades en: **Fuerza**, **Energía** e **Ingenio** al subir de nivel.
  * Dado un **Personaje**, quiero que una vez distribuidos los puntos de habilidades, no puedan ser redistribuidos.
  
* Como jugador, quiero aumentar mis habilidades para poder manipular ítems de manera más eficiente.
  * Dado un **Personaje**, quiero que para cierto **Item** se necesita una cantidad determinada de puntos de habilidad.
  * Dado un **Personaje**, no debo poder equipar un **Item** si no poseo la **Fuerza**, **Energía** o **Ingenio** mínimo requerido.
 
* Como jugador, quiero equipar items para poder potenciar mis habilidades.
  * Dado un **Personaje**, quiero que al equipar cierto Item me aumente o decremente la cantidad de **Puntos de Defensa** o **Puntos de ataque**.
  * Dado un **Personaje**, no debo poder desequipar los items obtenidos.
  * Dado un **Personaje**, quiero poder equipar todos los Items que vaya recogiendo.

* Como jugador, quiero disponer de habilidades de Fuerza, Energía o Ingenio para afectar a mis puntos de ataque y defensa.
  * Dado un **Personaje**, al aumentar/decrementar su Fuerza, debe aumentar o decrementar su **Defensa**.
  * Dado un **Personaje**, al aumentar/decrementar su Ingenio, debe aumentar o decrementar su **Ataque**.
  * Dado un **Personaje**, al aumentar/decrementar su Energía, debe aumentar o decrementar su **Ataque**.
  
* Como jugador, quiero encontrarme con otros jugadores en el mismo mundo para aliarse a ellos o combatir contra ellos.
  * Dado una **Alianza**, esta depende de la **raza** que haya escogido.
  * Dado un **Personaje**, no debo poder escoger mas de una **Alianza**.
  * Dado un **Personaje**, no debo poder atacar compañeros de mi propia **Alianza**.
  * Dado un **Personaje**, quiero poder atacar a Jugadores de **Alianzas enemigas**.
  
* Como jugador, quiero aliarme con otro jugador para combatir junto a él y aumentar la experiencia que recolectamos en ese tiempo.
  * Dado un **Personaje**, quiero obtener un bonus de experiencia al eliminar **NPC's** o **Personajes enemigos** al estar en una **Alianza**.
  
* Como jugador, quiero combatir contra otros jugadores para obtener sus ítems al derrotarlos.
  * Dado un **Personaje**, quiero que al estar en un combate con cierta cantidad de aliados, mis enemigos droppeen la misma cantidad de items que de aliados sobrevivientes del combate.
  * Dado un **Personaje**, quiero eliminar **Personajes enemigos** para poder tomar su mejor item.
  * Dado un **Personaje enemigo**, quiero que droppee su mejor item al finalizar el combate.

* Como jugador, quiero cambiar las alianzas establecidas cada cierta cantidad de tiempo para poder traicionar a mis aliados
  * Dado un **Personaje**, quiero que dado un tiempo mínimo de 5 minutos de estar en una **Alianza** se me permita cambiar la misma.
