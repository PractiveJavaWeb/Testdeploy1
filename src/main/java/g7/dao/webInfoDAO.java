package g7.dao;
import java.util.List;
import g7.model.webInfo;
public interface webInfoDAO {
	webInfo findByid(int id);
	List<webInfo> findAllWebpages();
	void save(webInfo webInfo);
	void deleteById(int id);
}
