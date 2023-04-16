package com.accesodatos.jsfjdbc.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
/*Como vamos a tratar distintos tipos de datos, entidades en cada dato, vamos a hacer parametrizable esta interfaz, 
 * así que le pondremos el tipo genérico T*/
	
	
	/* recuperar un registro en concreto, según su ID. 
	 * Claro que puede que no encuentre ninguno, así que el método get recibirá el ID y devolverá un objeto Optional del tipo genérico de la clase. 
	 */
	Optional<T> get(long id);
	
	/*Generalmente, también necesitaremos recuperar todos los registros, así que tenemos el método getAll, que no recibe nada, y devuelve una lista 
	 * de objetos de ese tipo genérico. */
	List<T> getAll();
	
	/*El método Save recibirá uno de esos objetos y no devolverá nada, porque lo habrá guardado en base de datos. */	
	void save(T t);
	
	/* Como afortunadamente los datos no están cincelados en mármol, necesitaremos ofrecer la posibilidad de actualizarlos, Update, 
	 * que también recibirá el objeto a actualizar y que, de nuevo, no nos devolverá nada. */
	void update(T t);
	
	/*Y finalmente, solo nos queda el borrado, delete. Y como en el resto de casos, recibirá el objeto y no nos devolverá nada. */
	void delete(T t);
}
