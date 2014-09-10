package kr.ac.korea.mobide.sigmapi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by Koo Lee on 2014-09-11.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Score {
    private String name;
    private double score;
}
