package com.github.wadrob.myset.domain.service;

import com.github.wadrob.myset.domain.model.Tag;
import com.github.wadrob.myset.domain.model.User;
import com.github.wadrob.myset.domain.repository.TagRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class TagService {

    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public List<Tag> tagsForUser (User user){
        return tagRepository.findAllByUser(user);
    }

    public List <Tag> favoritesTags (List <Tag> list) {
        Map<Tag, Integer> tagsMap = new HashMap<>();
        LinkedHashMap<Tag, Integer> sortedTagMap = new LinkedHashMap<>();
        for (Tag tag : list) {
            Long num = tagRepository.countAllByName(tag.getName());
            tagsMap.put(tag, num.intValue());
        }
        // TODO Tu jest ładnie :)
        tagsMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(x -> sortedTagMap.put(x.getKey(), x.getValue()));
        List<Tag> tags = threeTags(sortedTagMap);
        return tags;
    }

    public List <Tag> threeTags (Map <Tag, Integer> map){
        List <Tag> tags = new ArrayList<Tag>(map.keySet());
        // TODO a co jak nie ma 3 tagów? ;)
        //     aka HURA OPTYMISTYCZNY KOD
        return tags.subList(0, 3);

    }
}
