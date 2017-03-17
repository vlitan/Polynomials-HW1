package logic;

import java.util.ArrayList;

public interface Operation<T> { // operation generic interface
	  ArrayList<T> execute(T...m);
}
