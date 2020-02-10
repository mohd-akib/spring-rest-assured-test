package springRestExp.rest.repository;

import org.springframework.data.repository.CrudRepository;
import springRestExp.rest.data.Channel;

public interface ChannelRepository extends CrudRepository<Channel, Long> {
}
