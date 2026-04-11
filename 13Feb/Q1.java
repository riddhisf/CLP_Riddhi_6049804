package M1Mock;
import java.util.*;

public class Q1 {
	public static void main(String [] args) {
		List<List<String>> logs= new ArrayList<>();
		
		logs.add(Arrays.asList("01-01-2023", "14:00", "ERROR", "failed"));
        logs.add(Arrays.asList("01-01-2023", "15:00", "INFO", "established"));
        logs.add(Arrays.asList("01-01-2023", "01:30", "ERROR", "failed"));

        List<List<String>> result = Result.extractErrorLogs(logs);

        for (List<String> log : result) {
            System.out.println(log);
        }

	}

}

/*class Result{
	public static List<List<String>> extractErrorLogs(List<List<String>> logs){
		List<List<String>> filtered= new ArrayList<>();
		for(List<String> log: logs) {
			String status=log.get(2);
			if(status.equals("ERROR")||status.equals("CRITICAL")) {
				filtered.add(log);
			}
		}
		
		Collections.sort(filtered, new Comparator<List<String>>() {
			public int compare(List<String> a, List<String> b) {
				String[] d1=a.get(0).split("-");
				String[] d2=b.get(0).split("-");
				
				int year1= Integer.parseInt(d1[2]);
				int year2= Integer.parseInt(d2[2]);
				if(year1!=year2) return year1-year2;
				
				int month1= Integer.parseInt(d1[1]);
				int month2= Integer.parseInt(d2[1]);
				if(month1!=month2) return month1-month2;
				
				int day1= Integer.parseInt(d1[0]);
				int day2= Integer.parseInt(d2[0]);
				if(day1!=day2) return day1-day2;
				
				String [] t1=a.get(1).split(":");
				String [] t2=b.get(1).split(":");
				
				int hour1= Integer.parseInt(t1[0]);
				int hour2= Integer.parseInt(t2[0]);
				if(hour1!=hour2) return hour1-hour2;
				
				int min1= Integer.parseInt(t1[1]);
				int min2= Integer.parseInt(t2[1]);
				if(min1!=min2) return min1-min2;
				
				return 0;
			}
		});
		
		return filtered;
	}
}*/

/*class Result{
	public static List<List<String>> extractErrorLogs(List<List<String>> logs){
		List<List<String>> filtered=new ArrayList<>();

		for(List<String> log:logs){
			if(log.get(2).equals("ERROR")||log.get(2).equals("CRITICAL")){
				filtered.add(log);
			}
		}

		Map<List<String>,String> keyMap=new HashMap<>();

		for(List<String> log:filtered){
			String[]d=log.get(0).split("-");
			String[]t=log.get(1).split(":");
			String key=d[2]+d[1]+d[0]+t[0]+t[1]; // YYYYMMDDHHMM
			keyMap.put(log,key);
		}

		Collections.sort(filtered,(a,b)->keyMap.get(a).compareTo(keyMap.get(b)));

		return filtered;
	}
}*/

class Result{
	public static List<List<String>> extractErrorLogs(List<List<String>> logs){

		return logs.stream()
			.filter(log->log.get(2).equals("ERROR")||log.get(2).equals("CRITICAL"))
			.sorted(Comparator.comparingLong(Result::getTime))
			.toList();
	}

	private static long getTime(List<String> log){
		String[]d=log.get(0).split("-");
		String[]t=log.get(1).split(":");
		return Long.parseLong(d[2]+d[1]+d[0]+t[0]+t[1]);
	}
}

