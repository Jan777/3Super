package alianza;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import personaje.Atacable;
import personaje.Personaje;

public class Alianza {

	protected List<Personaje> alianza = new LinkedList<Personaje>();

	public void atacar(Alianza alianzaAtacada) {

		Atacable victima = alianzaAtacada.obtenerProximaVictima();

		for (Personaje atacante : alianza) {
			atacante.atacar(victima);
		}
	}

	public boolean agregar(Personaje personaje) {

		return alianza.add(personaje);
	}

	public Atacable obtenerProximaVictima() {

		depurarBatallon(); // Limpia personajes con vida 0

		if (alianza.isEmpty()) {
			throw new RuntimeException("El batallon de Personajes esta vacio");
		}

		return alianza.get(0); // Retorno el primer personaje de la Lista
	}

	public final void depurarBatallon() {

		Iterator<Personaje> iter = alianza.iterator();

		while (iter.hasNext()) {

			if (!iter.next().estaVivo())
				iter.remove();
		}
	}
}