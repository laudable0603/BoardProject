package service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import repository.FreeDAO;

public class FreeListService implements FreeService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		FreeDAO dao = FreeDAO.getInstance();
		Optional<String> opt = Optional.ofNullable(request.getParameter("freeNo"));
		int freeNo = Integer.parseInt(opt.orElse("0"));
		request.setAttribute("free", FreeDAO.getInstance().hitCount(freeNo));
		request.setAttribute("frees", dao.selectAllFrees());
		
		return new ActionForward("/free/list.jsp", false);
	}

}
