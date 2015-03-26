package kr.ac.korea.mobide.sigmapi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * Created by Koo Lee on 3/24/2015.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Conceptnet5Data {
    private List<Conceptnet5Item> edges;
    private float maxScore;
    private int numFound;
}
