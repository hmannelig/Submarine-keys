package counter;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Getter
@Setter
@Slf4j
public class Power {

    int gammaRateBit;
    int epsilonRateBit;

    public Power() {

    }

    public void calculateGammaAndEpsilonRates(List<String> values) {
        int[] temp = new int[values.get(0).length()];

        values.forEach(
                (s) -> {
                    for(int i = 0; i < s.length(); ++i) {
                        temp[i] += Character.getNumericValue(s.charAt(i));
                    }
                }
        );

        StringBuilder g = new StringBuilder();
        StringBuilder e = new StringBuilder();

        for (int j : temp) {
            if (j > values.size() / 2) {
                g.append(1);
                e.append(0);
            } else {
                g.append(0);
                e.append(1);
            }
        }

        this.gammaRateBit = Integer.parseInt(g.toString(), 2);
        this.epsilonRateBit = Integer.parseInt(e.toString(), 2);
    }

    public int getPowerConsumption() {
        return this.gammaRateBit * this.epsilonRateBit;
    }
}
