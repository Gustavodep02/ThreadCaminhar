package Controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class CaminharController extends Thread{
	Random random = new Random();

	int permissoes;
	int id;
	Semaphore semaforo = new Semaphore(permissoes);
	public CaminharController(int id,int permissoes, Semaphore semaforo) {
		this.permissoes = permissoes;
		this.semaforo = semaforo;
		this.id = id;
	}
	@Override
	public void run() {
		andar();
		try {
			semaforo.acquire();
			passarPorta();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			semaforo.release();
		}
	}
	public void andar() {
		int distaciaTotal = 200;
		int distanciaAtual = 0;
		while(distanciaAtual < distaciaTotal) {
            try {
                Thread.sleep(1000);
                System.out.println("Pessoa "+id+" andou "+distanciaAtual+" metros");
                distanciaAtual += (int)(Math.random() * 3) + 4;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
	}
	public void passarPorta() {
		int sleep = (int) ((Math.random() * 1001) + 1000);
		System.out.println("Pessoa "+id+" esta abrindo e cruzando a porta");
        try {
			Thread.sleep(sleep);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}}
