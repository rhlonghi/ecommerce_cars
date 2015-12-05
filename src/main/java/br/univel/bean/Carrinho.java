package br.univel.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.univel.model.Carro;

@ApplicationScoped
public class Carrinho implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	
	HashMap<Long, Integer> map = new HashMap<Long ,Integer>();
	
	List<Carro> carros = new ArrayList<Carro>();

	public List<Carro> getCarros() {
		return carros;
	}

	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}
	
	public synchronized void addCarro(Carro c, int qtd){
		boolean flag = false;
		map.put(c.getId(), qtd);
		
		if(!carros.isEmpty())
			for(Carro car : carros){
				if(car.getId() != c.getId()){
					map.put(c.getId(), qtd);
					flag = false;
				}else{
					map.replace(c.getId(), qtd);
					flag = true;
				}
			}
		else
			carros.add(c);
		if(flag) carros.remove(c);
	}
	
	public synchronized void limpar(){
		carros.clear();
		map.clear();
	}
	
	public synchronized HashMap<Long, Integer> getMap(){
		return map;
	}
}