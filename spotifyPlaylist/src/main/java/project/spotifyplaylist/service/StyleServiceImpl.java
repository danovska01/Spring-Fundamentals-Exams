package project.spotifyplaylist.service;

import org.springframework.stereotype.Service;
import project.spotifyplaylist.model.entity.Style;
import project.spotifyplaylist.model.entity.enums.StyleNameEnum;
import project.spotifyplaylist.repository.StyleRepository;

import java.util.Arrays;

@Service
public class StyleServiceImpl implements StyleService {

    private final StyleRepository styleRepository;

    public StyleServiceImpl(StyleRepository styleRepository) {
        this.styleRepository = styleRepository;
    }


    @Override
    public void initStyles() {
        if (styleRepository.count() == 0) {
            Arrays.stream(StyleNameEnum.values())
                    .forEach(styleName -> {

                        Style style = new Style();

                        style.setStyleName(styleName);
                        style.setDescription("Description for " + styleName);

                        styleRepository.save(style);
                    });
        }
    }
}
