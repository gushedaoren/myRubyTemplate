import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author frankswu
 *
 */
@Entity
@Table(name = "tb_<%= key.downcase %>")
public class <%= key %> extends IdEntity {
	<%
		value.each do |k,v|
		
		propName = k
		propType = v.split(',')[0]
		if propType.rindex(/List$/) != nil || propType.rindex(/s$/) != nil 
		  propTypeValue = " = Lists.newArrayList()"
          propAnoantion = "@OneToMany || @ManyToMany@joinTable@Fetch@orderby@cache"				 
		end
		propDesc = v.split(',')[1]
	%>
    /** <%= propDesc %> */<%= propAnoantion %>
    private <%= propType %> <%= propName %><%= propTypeValue%>;<% end%>


}