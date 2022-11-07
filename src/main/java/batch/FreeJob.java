package batch;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import domain.Free;
import repository.FreeDAO;

public class FreeJob implements Job {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		
		List<Free> top1 = FreeDAO.getInstance().selectFreeTop1();
		
		File file = new File("top.txt");
		try {
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			
			for(Free f : top1) {
				bw.write("게시글번호" + f.getFreeNo());
				bw.write("작성자" + f.getWriter());
				bw.write("제목" + f.getTitle());
				bw.write("작성 IP" + f.getIp());
				bw.write("조회수 " + f.getHit());
				bw.write("내용 \n" + f.getContent());
				System.out.println("파일생성" + f.getTitle());
			}
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		
	}

}
