/**
 * Copyright (C) 2011 Esup Portail http://www.esup-portail.org
 * Copyright (C) 2011 UNR RUNN http://www.unr-runn.fr
 * Copyright (C) 2011 RECIA http://www.recia.fr
 * @Author (C) 2011 Vincent Bonamy <Vincent.Bonamy@univ-rouen.fr>
 * @Contributor (C) 2011 Jean-Pierre Tran <Jean-Pierre.Tran@univ-rouen.fr>
 * @Contributor (C) 2011 Julien Marchal <Julien.Marchal@univ-nancy2.fr>
 * @Contributor (C) 2011 Julien Gribonvald <Julien.Gribonvald@recia.fr>
 * @Contributor (C) 2011 David Clarke <david.clarke@anu.edu.au>
 * @Contributor (C) 2011 BULL http://www.bull.fr
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.esupportail.portlet.stockage.services.uri;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class RegUriManipulateService implements UriManipulateService {
	protected static final Log log = LogFactory.getLog(RegUriManipulateService.class);

	protected String regexp = "";
	protected String replacement = "";
	
	public void setRegexp(String regexp) {
		this.regexp = regexp;
	}

	public void setReplacement(String replacement) {
		this.replacement = replacement;
	}

	public  String manipulate(String uri) {
		String outUri = "";
		outUri = uri;
		// we check if the path is a regular expression
		if (regexp!=null && replacement !=null) {			
			Pattern p = Pattern.compile(regexp, Pattern.CASE_INSENSITIVE);
			Matcher m = p.matcher(outUri);
			outUri = m.replaceAll(replacement);			
		}
		if(log.isDebugEnabled())
			log.debug("RegUriManipulateService:: input uri :"+uri+" -- output uri : "+outUri);
		
		return outUri;
	}	
}