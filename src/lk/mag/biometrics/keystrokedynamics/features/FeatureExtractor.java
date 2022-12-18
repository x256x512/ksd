package lk.mag.biometrics.keystrokedynamics.features;

import java.util.HashMap;
import lk.mag.biometrics.keystrokedynamics.input.EventCollector;
import lk.mag.biometrics.keystrokedynamics.util.Pair;


public class FeatureExtractor {

    public static FeatureModel extractFeatures(EventCollector ec) {
        HashMap<Integer, Long> keyDurationAvg = new HashMap<>();
        HashMap<Pair, Long> digraphDelayAvg = new HashMap<>();

        for (int key : ec.getTotalKeyCounts().keySet()) {
            keyDurationAvg.put(key, ec.getTotalKeyDurations().get(key) / ec.getTotalKeyCounts().get(key));
        }
        for (int key : ec.getDigraphCounts().keySet()) {
            for (Integer key2 : ec.getDigraphCounts().get(key).keySet()) {
                Pair pi = new Pair(key, key2);
                digraphDelayAvg.put(pi, ec.getDigraphDelays().get(key).get(key2) / ec.getDigraphCounts().get(key).get(key2));
            }
        }

        FeatureModel m = new FeatureModel();
        m.setDigraphDelayAvg(digraphDelayAvg);
        m.setKeyDurationAvg(keyDurationAvg);
        return m;
    }
}
