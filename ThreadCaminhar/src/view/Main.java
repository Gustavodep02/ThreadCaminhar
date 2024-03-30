package view;

import java.util.concurrent.Semaphore;

import Controller.CaminharController;

public class Main {

	public static void main(String[] args) {
		int id = 1;
	    int permissoes = 1 ;
	    Semaphore semaforo = new Semaphore(permissoes);
	    for (int i = 0; i < 4; i++) {
            CaminharController c  = new CaminharController(id,permissoes, semaforo);
            c.start();
            id++;
        }
	}

}
