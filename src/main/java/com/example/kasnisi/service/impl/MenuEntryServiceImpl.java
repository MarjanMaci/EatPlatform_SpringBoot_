package com.example.kasnisi.service.impl;

import com.example.kasnisi.model.MenuEntry;
import com.example.kasnisi.model.exceptions.menuEntryNotFound;
import com.example.kasnisi.repository.MenuEntryRepository;
import org.springframework.stereotype.Service;

@Service
public class MenuEntryServiceImpl implements com.example.kasnisi.service.MenuEntryService {
    public MenuEntryRepository menuEntryRepository;

    public MenuEntryServiceImpl(MenuEntryRepository menuEntryRepository){
        this.menuEntryRepository=menuEntryRepository;
    }

    @Override
    public MenuEntry findById(Long id) {
        MenuEntry menuEntry=menuEntryRepository.findById(id).orElseThrow(()->new menuEntryNotFound(id));
        return menuEntry;
    }

    @Override
    public String[] transliterate(String id) {
        char[] abcCyr =   {' ','а','б','в','г','д','е', 'ж','з','и','к','л','м','н','о','п','р','с','т','у','ф','х', 'ц','ч', 'ш',',','.'};
        char[] abcLat = {' ','a','b','v','g','d','e','z','z','i','k','l','m','n','o','p','r','s','t','u','f','h','c','c','s',',','.'};
        StringBuilder builder = new StringBuilder();
        int cont=1000000;
        for (int i = 0; i < id.length(); i++) {
            if(cont==i){continue;}
            for (int x = 0; x < abcLat.length; x++ ) {
                if (id.charAt(i) == abcLat[x]) {
                    if(i+1 == id.length()) {
                        builder.append(abcCyr[x]);
                        break;
                    }else{
                        if (abcLat[x] == 'z' && id.charAt(i + 1) == 'h') {
                            builder.append(abcCyr[7]);
                            cont = i + 1;
                            break;
                        } else if (abcLat[x] == 'c' && id.charAt(i + 1) == 'h') {
                            builder.append(abcCyr[23]);
                            cont = i + 1;
                            break;
                        } else if (abcLat[x] == 's' && id.charAt(i + 1) == 'h') {
                            builder.append(abcCyr[24]);
                            cont = i + 1;
                            break;
                        } else {
                            builder.append(abcCyr[x]);
                            break;
                        }
                    }
                }
            }
        }
        String[] ingredients= builder.toString().split(",");
        return ingredients;
    }
}
