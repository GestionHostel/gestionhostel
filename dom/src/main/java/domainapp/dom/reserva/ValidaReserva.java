package domainapp.dom.reserva;

import org.apache.isis.applib.AbstractSubscriber;
import org.apache.isis.applib.IsisApplibModule.PropertyDomainEvent;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.services.eventbus.AbstractDomainEvent;
import org.apache.isis.applib.services.i18n.TranslatableString;
import org.joda.time.LocalDate;

import com.google.common.eventbus.Subscribe;



public interface ValidaReserva {
	
	class FechaInDomainEvent extends PropertyDomainEvent<Reserva, LocalDate> {}
	
	LocalDate getFechaIn();
	void setFechaIn(LocalDate fechaIn);
	
	@DomainService(nature = NatureOfService.DOMAIN)
	class ValidationSubscriber extends AbstractSubscriber {
		@Subscribe
		public void on(ValidaReserva.FechaInDomainEvent ev) {
			if(ev.getEventPhase() == AbstractDomainEvent.Phase.VALIDATE) {
				final LocalDate fechaIn = ev.getNewValue();
				ev.invalidate(ValidationRules.reasonIfInvalid(fechaIn));
			}
		}
		
		  class ValidationRules {
			public static String reasonIfInvalid(LocalDate fechaIn){
				return fechaIn != null && fechaIn.isAfter(LocalDate.now())
				? "Fecha mal"
				: null;
			}
		}
	}

}
