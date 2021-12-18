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

    int[] bitMode;
    int n;

    public Power() {

    }

    public int[] calculateBitMode(List<String> values) {
        int[] temp = new int[values.get(0).length()];

        values.forEach(
                (s) -> {
                    for(int i = 0; i < s.length(); ++i) {
                        temp[i] += Character.getNumericValue(s.charAt(i));
                    }
                }
        );

        return temp;
    }

    public void getGammaAndEpsilonRateBits(List<String> values) {
        this.bitMode = calculateBitMode(values);

        StringBuilder g = new StringBuilder();
        StringBuilder e = new StringBuilder();

        for (int j : bitMode) {
            if (j > values.size() / 2) {
                g.append(1);
                e.append(0);
            } else {
                g.append(0);
                e.append(1);
            }
        }

        this.n = values.size();
        this.gammaRateBit = Integer.parseInt(g.toString(), 2);
        this.epsilonRateBit = Integer.parseInt(e.toString(), 2);
    }

    public int getOxygenGeneratorRating() {

        StringBuilder sb = new StringBuilder();
        for(Integer i : bitMode) {
            if((i >= n / 2)) {
                sb.append(1);
            } else {
                sb.append(0);
            }
        }
        System.out.println(sb.toString());
        return Integer.parseInt(sb.toString(), 2);
    }

    public int getCO2ScrubberRating() {
        StringBuilder sb = new StringBuilder();
        for(Integer i : bitMode) {
            if((i >= n / 2)) {
                sb.append(0);
            } else {
                sb.append(1);
            }
        }
        System.out.println(sb.toString());
        return Integer.parseInt(sb.toString(), 2);
    }

    public int getPowerConsumption() {
        return this.gammaRateBit * this.epsilonRateBit;
    }

    public int lifeSupportRating() {
        return this.getOxygenGeneratorRating() * this.getCO2ScrubberRating();
    }
}
