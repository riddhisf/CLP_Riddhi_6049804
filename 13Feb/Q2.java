package M1Mock;
import java.util.*;

enum ActionEnum {
    feature1Button,
    feature2Button,
    feature3Button
}

interface AnalyticsStore {
    void storeActions(Queue<ActionEnum> actions);
}

class InMemoryAnalyticsStore implements AnalyticsStore {

    private List<ActionEnum> storedActions = new ArrayList<>();

    @Override
    public void storeActions(Queue<ActionEnum> actions) {
        while (!actions.isEmpty()) {
            storedActions.add(actions.poll());
        }
    }

    public List<ActionEnum> getStoredActions() {
        return storedActions;
    }
}

interface IAnalytics {

    void registerAction(ActionEnum action);

    int getNumberOfActionRegisteredButNotSentToAnalyticsStore();

    int getTotalNumberOfLoggedActions();

    List<ActionEnum> getMostFrequentlyUsedActions();
}

class Analytics implements IAnalytics {

    private AnalyticsStore analyticsStore;
    private int K;
    private Queue<ActionEnum> buffer;
    private Map<ActionEnum,Integer> freqMap;
    private int totalActions;

    public Analytics(AnalyticsStore analyticsStore,int K){
        this.analyticsStore=analyticsStore;
        this.K=K;
        buffer=new LinkedList<>();
        freqMap=new HashMap<>();
        totalActions=0;
    }

    @Override
    public void registerAction(ActionEnum action){
        buffer.add(action);
        freqMap.put(action,freqMap.getOrDefault(action,0)+1);
        totalActions++;

        if(buffer.size()==K){
            analyticsStore.storeActions(buffer);
            buffer.clear();
        }
    }

    @Override
    public int getNumberOfActionRegisteredButNotSentToAnalyticsStore(){
        return buffer.size();
    }

    @Override
    public int getTotalNumberOfLoggedActions(){
        return totalActions;
    }

    @Override
    public List<ActionEnum> getMostFrequentlyUsedActions(){
        int maxFreq=0;
        for(int v:freqMap.values()){
            maxFreq=Math.max(maxFreq,v);
        }

        List<ActionEnum> res=new ArrayList<>();
        for(Map.Entry<ActionEnum,Integer> e:freqMap.entrySet()){
            if(e.getValue()==maxFreq){
                res.add(e.getKey());
            }
        }
        return res;
    }
}

public class Q2 {

    public static void main(String[] args) {

        InMemoryAnalyticsStore store = new InMemoryAnalyticsStore();
        Analytics analytics = new Analytics(store, 3);

        analytics.registerAction(ActionEnum.feature1Button);
        analytics.registerAction(ActionEnum.feature1Button);

        System.out.println(analytics.getTotalNumberOfLoggedActions());

        analytics.registerAction(ActionEnum.feature2Button);
        analytics.registerAction(ActionEnum.feature3Button);

        System.out.println(
                analytics.getNumberOfActionRegisteredButNotSentToAnalyticsStore()
        );

        analytics.registerAction(ActionEnum.feature2Button);

        List<ActionEnum> mostUsed = analytics.getMostFrequentlyUsedActions();
        for (ActionEnum action : mostUsed) {
            System.out.print(action + " ");
        }

        System.out.println();

        for (ActionEnum action : store.getStoredActions()) {
            System.out.print(action + " ");
        }
    }
}