package frame.game;

public class GameIn {

	public void GInsert(Db2DTO dto) throws Exception {

		Db2DAO dao = new Db2DAO();

		dao.insert(dto);
	}
}