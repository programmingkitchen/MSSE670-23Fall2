package com.fleetrental.model.services.factory;

import com.fleetrental.model.services.loginservice.ILoginService;
import com.fleetrental.model.services.loginservice.LoginServiceImpl;

/**
 * Simplistic implementation of a Service Factory. 
 * See  com.fleetrental.model.business.factory.ServiceFactory for a refined version
 *   
 * @author Mike.Prasad
 *
 */
public class ServiceFactory
{

   public ILoginService getLoginService()
   {
      return new LoginServiceImpl();
   }
}//end ServiceFactory