package example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vcap.service.BindRequest;
import vcap.service.CreateRequest;
import vcap.service.Provisioner;
import vcap.service.ServiceBinding;
import vcap.service.ServiceInstance;

import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Mike Heath <elcapo@gmail.com>
 */
public class ServiceProvisioner implements Provisioner {

	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceProvisioner.class);

	private final AtomicInteger counter = new AtomicInteger();

	@Override
	public ServiceInstance create(CreateRequest createRequest) {
		LOGGER.info("Creating service with name {} in space {}", createRequest.getName(), createRequest.getSpaceGuid());
		final Integer id = counter.incrementAndGet();
		final ServiceInstance serviceInstance = new ServiceInstance(id.toString());
		serviceInstance.addCredential("yourmom", "goes to college!");
		return serviceInstance;
	}

	@Override
	public void delete(String instanceId) {
		LOGGER.info("Deleting service with id {}", instanceId);
	}

	@Override
	public ServiceBinding bind(BindRequest bindRequest) {
		LOGGER.info("Binding service {}", bindRequest.getServiceInstanceId());
		final Integer id = counter.incrementAndGet();
		final ServiceBinding serviceBinding = new ServiceBinding(bindRequest.getServiceInstanceId(), id.toString());
		serviceBinding.addCredential("Pedro", "Offers you his protection");
		return serviceBinding;
	}

	@Override
	public void unbind(String instanceId, String bindingId) {
		LOGGER.info("Unbinding {} on service instance {}", bindingId, instanceId);
	}

	@Override
	public Iterable<String> serviceInstanceIds() {
		return Collections.emptyList();
	}

	@Override
	public Iterable<String> bindingIds(String s) {
		return Collections.emptyList();
	}

	@Override
	public void removeOrphanedBinding(String s, String s2) {
		// Do nothing
	}

	@Override
	public void removeOrphanedServiceInstance(String s) {
		// Do nothing
	}

}
