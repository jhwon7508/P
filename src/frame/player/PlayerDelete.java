package frame.player;

public class PlayerDelete {

	public void PDelete(Db1DTO dto) throws Exception {
		Db1DAO dao = new Db1DAO();

		dao.delete(dto);
	}

}
