import java.util.List;

public interface DAOInterface<T> {

//    A DAO abstract class or interface for the following methods

        public T findById(int id);


       public List<T> findAll();
       public T update(T dto);
       public T create(T dto);
       public  void delete(int id);


}
