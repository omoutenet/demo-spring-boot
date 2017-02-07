package ch.ebu.ipush;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface NewsRepository extends JpaRepository<News, String>, PagingAndSortingRepository<News, String> {

}