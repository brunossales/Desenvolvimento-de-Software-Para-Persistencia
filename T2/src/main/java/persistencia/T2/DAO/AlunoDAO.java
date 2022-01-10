package persistencia.T2.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import persistencia.T2.entity.Aluno;
import persistencia.T2.entity.entitysAux.NameAndCountD;
import persistencia.T2.entity.entitysAux.NamedAndDisciplin;
import persistencia.T2.entity.entitysAux.NamedAndEmail;

import javax.swing.text.html.Option;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface AlunoDAO extends JpaRepository<Aluno, Integer> {
    @Query("SELECT A FROM Aluno A WHERE A.id = :id")
    public Aluno buscaPrimeiroAluno(Integer id);
    @Query("SELECT A FROM Aluno A WHERE A.nome LIKE %:str%")
    public List<Aluno> findByNomeStartingWith(String str);

    public void deleteById(Integer id);
    public List<Aluno> findAll();
    public Aluno findFirstByCpf(String str);

    //Named Querye
    @Query(name = "nomeEemail")
    public List<NamedAndEmail> buscaPorCodigoBD(Integer matricula);

    @Query(name = "dataBE")
    public List<Aluno> buscaPorDataBE(Date data);

    @Query(name = "nameAndCount")
    public List<NameAndCountD> buscaCountBC();
}
