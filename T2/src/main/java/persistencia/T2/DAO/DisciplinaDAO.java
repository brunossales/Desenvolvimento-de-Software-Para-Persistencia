package persistencia.T2.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import persistencia.T2.entity.Aluno;
import persistencia.T2.entity.Disciplina;

import java.util.List;

@Repository
public interface DisciplinaDAO extends JpaRepository<Disciplina, Long> {
    @Query("SELECT D FROM Disciplina D WHERE D.id = :id")
    public Disciplina buscaPrimeiraDisciplina(Integer id);

    public void deleteById(Integer id);
    public List<Disciplina> findAll();

    //Named Querye
    @Query(name = "findCodigo")
    public List<Aluno> buscaPorCodigo(Integer cod);
}
