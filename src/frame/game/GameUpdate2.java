package frame.game;


public class GameUpdate2 {

	public void GUpdate(Db2DTO dto) throws Exception {
		Db2DAO dao = new Db2DAO();

		dao.update(dto);
	}

}