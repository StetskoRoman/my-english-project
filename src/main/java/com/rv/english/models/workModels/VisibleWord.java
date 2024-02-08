package com.rv.english.models.workModels;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VisibleWord {

    private Long countShow;
    private Long countAdds;
    private Long countComplains;
    private boolean badWord;

    private boolean goodWord;

}
