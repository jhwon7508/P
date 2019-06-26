package frame.game;

public class GameDelete {

	public void GDelete(Db2DTO dto) throws Exception {
		Db2DAO dao = new Db2DAO();

		dao.delete(dto);
	}

}
