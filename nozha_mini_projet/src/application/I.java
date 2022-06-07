package application;

import java.util.List;

public interface I <T>{
	boolean delete (T o);
	T findByMat(int mat);
	List <T> findAll();
}
