package frame.player;

public class PlayerIn {

	public void PInsert(Db1DTO dto) throws Exception {
		Db1DAO dao = new Db1DAO();

		dao.insert(dto);
	}

}
