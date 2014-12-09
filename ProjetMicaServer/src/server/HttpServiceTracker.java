package server;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.http.HttpService;
import org.osgi.util.tracker.ServiceTracker;

public class HttpServiceTracker extends ServiceTracker {

        public HttpServiceTracker(BundleContext context) {
                super(context, HttpService.class.getName(), null);
        }

        public Object addingService(ServiceReference reference) {
                HttpService httpService = (HttpService) super.addingService(reference);
                if (httpService == null)
                        return null;

                try {
                        System.out.println("Registering servlet at /requirements");
                        httpService.registerServlet("/requirements", new RequirementsHandlerServlet(), null,
                                        null);
                } catch (Exception e) {
                        e.printStackTrace();
                }

                return httpService;
        }
        
        public void removedService(ServiceReference reference, Object service) {
            HttpService httpService = (HttpService) service;

            System.out.println("Unregistering /requirements");
            httpService.unregister("/requirements");

            super.removedService(reference, service);
          }
}
