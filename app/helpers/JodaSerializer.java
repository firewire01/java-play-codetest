package helpers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import org.joda.time.DateTime;

/**
 *
 * @author marlon
 */
public class JodaSerializer extends JsonSerializer<DateTime>
{

    @Override
    public void serialize(DateTime t, JsonGenerator jg, SerializerProvider sp) throws IOException, JsonProcessingException
    {
        jg.writeString(t.toString());
    }

}
