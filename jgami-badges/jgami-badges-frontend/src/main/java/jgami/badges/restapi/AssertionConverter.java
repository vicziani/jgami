package jgami.badges.restapi;

import jgami.courses.backend.BadgeInfo;
import org.springframework.core.convert.converter.Converter;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AssertionConverter implements Converter<BadgeInfo, Assertion> {

    public static final String SALT = "JTechLogBadge";

    private String path;

    public AssertionConverter(String path) {
        this.path = path;
    }

    @Override
    public Assertion convert(BadgeInfo badgeInfo) {
        Assertion assertion = new Assertion();
        assertion.setUid(badgeInfo.id.toString());
        Recipient recipient = new Recipient();
        recipient.setType("EMAIL");
        recipient.setHashed(true);
        recipient.setSalt(SALT);
        recipient.setIdentity(hash(badgeInfo.email + SALT));
        assertion.setRecipient(recipient);
        assertion.setIssuedOn(badgeInfo.issuedAt);
        assertion.setBadge(path + "/api/courses/" + badgeInfo.courseId);
        Verify verify = new Verify();
        verify.setType("hosted");
        verify.setUrl(path + "/api/assertions/" + badgeInfo.id.toString());
        assertion.setVerify(verify);
        return assertion;
    }

    private String hash(String text) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(text.getBytes(StandardCharsets.UTF_8));
            return "sha265$" + DatatypeConverter.printHexBinary(hash);
        }
        catch (NoSuchAlgorithmException nsae) {
            throw new IllegalStateException("Invalid algorithm", nsae);
        }
    }
}
