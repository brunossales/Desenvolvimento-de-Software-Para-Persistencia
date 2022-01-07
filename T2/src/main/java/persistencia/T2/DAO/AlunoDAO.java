package persistencia.T2.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import persistencia.T2.entity.Aluno;
import persistencia.T2.entity.entitysAux.NamedAndDisciplinas;
import persistencia.T2.entity.entitysAux.NamedAndEmail;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Repository
public interface AlunoDAO extends JpaRepository<Aluno, Integer> {
    @Query("SELECT A FROM Aluno A WHERE A.id = :id")
    public Aluno buscaPrimeiroAluno(Integer id);

    //@Query("SELECT a.nome as nome, a.disciplinas as disciplinas FROM Aluno a WHERE a.nome like :nome%")
    //public List<NamedAndDisciplinas> procuraPorSubstringBA(String nome);

    //@Query("SELECT COUNT(A.disciplinas) FROM Aluno A WHERE A.id = :id")
    //public long contaDisciplinas(Integer id);


    public void deleteById(Integer id);
    public List<Aluno> findAll();
    public List<Aluno> findByNomeStartingWith(String str);

    //Named Querye
    @Query(name = "nomeEemail")
    public List<NamedAndEmail> buscaPorCodigoBD(Integer matricula);

    @Query(name = "dataBE")
    public List<Aluno> buscaPorDataBE(Date data);
}
