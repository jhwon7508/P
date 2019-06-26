package frame.player;

public class PlayerUpdate2 {

	public void PUpdate(Db1DTO dto) throws Exception {
		Db1DAO dao = new Db1DAO();

		dao.update(dto);
	}
}