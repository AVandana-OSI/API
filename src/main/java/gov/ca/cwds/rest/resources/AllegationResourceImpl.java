package gov.ca.cwds.rest.resources;

import gov.ca.cwds.rest.api.persistence.legacy.Allegation;
import gov.ca.cwds.rest.services.AllegationService;
import gov.ca.cwds.rest.setup.ServiceEnvironment;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ResponseHeader;

import javax.validation.Valid;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implementation of {@link AllegationResource} delegating work to {@link AllegationResource}
 * 
 * @author CWDS API Team
 */
public class AllegationResourceImpl extends BaseResource<AllegationService>
		implements AllegationResource, CrudsResource<Allegation> {

	@SuppressWarnings("unused")
	private static final Logger LOGGER = LoggerFactory.getLogger(AllegationResourceImpl.class);
	
	private CrudsResource<Allegation> crudsResource;
	
	public AllegationResourceImpl(ServiceEnvironment serviceEnvironment, CrudsResource<Allegation> crudsResource) {
		super(serviceEnvironment, AllegationService.class);
		this.crudsResource = crudsResource;
	}
	
	/* (non-Javadoc)
	 * @see gov.ca.cwds.rest.resources.CrudsResource#get(java.lang.String, java.lang.String)
	 */
	@Override
	@ApiOperation(value = "Find Referral by id", response = Allegation.class)
	public Response get(String id, String acceptHeader) {
		return crudsResource.get(id, acceptHeader);
	}

	/* (non-Javadoc)
	 * @see gov.ca.cwds.rest.resources.CrudsResource#delete(java.lang.String, java.lang.String)
	 */
	@ApiOperation(value = "Delete Allegation", code = HttpStatus.SC_NO_CONTENT)
	@Override
	public Response delete(String id, String acceptHeader) {
		return crudsResource.delete(id, acceptHeader);
	}

	/* (non-Javadoc)
	 * @see gov.ca.cwds.rest.resources.CrudsResource#update(gov.ca.cwds.rest.api.persistence.PersistentObject, java.lang.String)
	 */
	@Override
	@ApiOperation(value = "Update Allegation", code = 204, response = Allegation.class)
	public Response update(@Valid Allegation persistentObject, String acceptHeader) {
		return crudsResource.update(persistentObject, acceptHeader);
	}

	/* (non-Javadoc)
	 * @see gov.ca.cwds.rest.resources.CrudsResource#create(gov.ca.cwds.rest.api.persistence.PersistentObject, java.lang.String, javax.ws.rs.core.UriInfo)
	 */
	@Override
	@ApiOperation(value = "Create Allegation", response = Allegation.class, code = 201, responseHeaders = @ResponseHeader(name = "Location", description = "Link to the newly created object", response = Object.class))
	public Response create(@Valid Allegation persistentObject, String acceptHeader, UriInfo uriInfo) {
		return crudsResource.create(persistentObject, acceptHeader, uriInfo);
	}
}