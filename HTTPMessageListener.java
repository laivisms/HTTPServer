// Generated from HTTPMessage.g4 by ANTLR 4.6
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link HTTPMessageParser}.
 */
public interface HTTPMessageListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link HTTPMessageParser#message}.
	 * @param ctx the parse tree
	 */
	void enterMessage(HTTPMessageParser.MessageContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTTPMessageParser#message}.
	 * @param ctx the parse tree
	 */
	void exitMessage(HTTPMessageParser.MessageContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTTPMessageParser#contents}.
	 * @param ctx the parse tree
	 */
	void enterContents(HTTPMessageParser.ContentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTTPMessageParser#contents}.
	 * @param ctx the parse tree
	 */
	void exitContents(HTTPMessageParser.ContentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTTPMessageParser#headerFields}.
	 * @param ctx the parse tree
	 */
	void enterHeaderFields(HTTPMessageParser.HeaderFieldsContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTTPMessageParser#headerFields}.
	 * @param ctx the parse tree
	 */
	void exitHeaderFields(HTTPMessageParser.HeaderFieldsContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTTPMessageParser#startLine}.
	 * @param ctx the parse tree
	 */
	void enterStartLine(HTTPMessageParser.StartLineContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTTPMessageParser#startLine}.
	 * @param ctx the parse tree
	 */
	void exitStartLine(HTTPMessageParser.StartLineContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTTPMessageParser#requestTarget}.
	 * @param ctx the parse tree
	 */
	void enterRequestTarget(HTTPMessageParser.RequestTargetContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTTPMessageParser#requestTarget}.
	 * @param ctx the parse tree
	 */
	void exitRequestTarget(HTTPMessageParser.RequestTargetContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTTPMessageParser#originForm}.
	 * @param ctx the parse tree
	 */
	void enterOriginForm(HTTPMessageParser.OriginFormContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTTPMessageParser#originForm}.
	 * @param ctx the parse tree
	 */
	void exitOriginForm(HTTPMessageParser.OriginFormContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTTPMessageParser#absolutePath}.
	 * @param ctx the parse tree
	 */
	void enterAbsolutePath(HTTPMessageParser.AbsolutePathContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTTPMessageParser#absolutePath}.
	 * @param ctx the parse tree
	 */
	void exitAbsolutePath(HTTPMessageParser.AbsolutePathContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTTPMessageParser#segment}.
	 * @param ctx the parse tree
	 */
	void enterSegment(HTTPMessageParser.SegmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTTPMessageParser#segment}.
	 * @param ctx the parse tree
	 */
	void exitSegment(HTTPMessageParser.SegmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTTPMessageParser#query}.
	 * @param ctx the parse tree
	 */
	void enterQuery(HTTPMessageParser.QueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTTPMessageParser#query}.
	 * @param ctx the parse tree
	 */
	void exitQuery(HTTPMessageParser.QueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTTPMessageParser#pchar}.
	 * @param ctx the parse tree
	 */
	void enterPchar(HTTPMessageParser.PcharContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTTPMessageParser#pchar}.
	 * @param ctx the parse tree
	 */
	void exitPchar(HTTPMessageParser.PcharContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTTPMessageParser#unreserved}.
	 * @param ctx the parse tree
	 */
	void enterUnreserved(HTTPMessageParser.UnreservedContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTTPMessageParser#unreserved}.
	 * @param ctx the parse tree
	 */
	void exitUnreserved(HTTPMessageParser.UnreservedContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTTPMessageParser#pctEncoded}.
	 * @param ctx the parse tree
	 */
	void enterPctEncoded(HTTPMessageParser.PctEncodedContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTTPMessageParser#pctEncoded}.
	 * @param ctx the parse tree
	 */
	void exitPctEncoded(HTTPMessageParser.PctEncodedContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTTPMessageParser#absoluteForm}.
	 * @param ctx the parse tree
	 */
	void enterAbsoluteForm(HTTPMessageParser.AbsoluteFormContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTTPMessageParser#absoluteForm}.
	 * @param ctx the parse tree
	 */
	void exitAbsoluteForm(HTTPMessageParser.AbsoluteFormContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTTPMessageParser#absoluteURI}.
	 * @param ctx the parse tree
	 */
	void enterAbsoluteURI(HTTPMessageParser.AbsoluteURIContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTTPMessageParser#absoluteURI}.
	 * @param ctx the parse tree
	 */
	void exitAbsoluteURI(HTTPMessageParser.AbsoluteURIContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTTPMessageParser#scheme}.
	 * @param ctx the parse tree
	 */
	void enterScheme(HTTPMessageParser.SchemeContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTTPMessageParser#scheme}.
	 * @param ctx the parse tree
	 */
	void exitScheme(HTTPMessageParser.SchemeContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTTPMessageParser#hierPart}.
	 * @param ctx the parse tree
	 */
	void enterHierPart(HTTPMessageParser.HierPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTTPMessageParser#hierPart}.
	 * @param ctx the parse tree
	 */
	void exitHierPart(HTTPMessageParser.HierPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTTPMessageParser#authority}.
	 * @param ctx the parse tree
	 */
	void enterAuthority(HTTPMessageParser.AuthorityContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTTPMessageParser#authority}.
	 * @param ctx the parse tree
	 */
	void exitAuthority(HTTPMessageParser.AuthorityContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTTPMessageParser#pathRootless}.
	 * @param ctx the parse tree
	 */
	void enterPathRootless(HTTPMessageParser.PathRootlessContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTTPMessageParser#pathRootless}.
	 * @param ctx the parse tree
	 */
	void exitPathRootless(HTTPMessageParser.PathRootlessContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTTPMessageParser#pathAbempty}.
	 * @param ctx the parse tree
	 */
	void enterPathAbempty(HTTPMessageParser.PathAbemptyContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTTPMessageParser#pathAbempty}.
	 * @param ctx the parse tree
	 */
	void exitPathAbempty(HTTPMessageParser.PathAbemptyContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTTPMessageParser#pathAbsolute}.
	 * @param ctx the parse tree
	 */
	void enterPathAbsolute(HTTPMessageParser.PathAbsoluteContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTTPMessageParser#pathAbsolute}.
	 * @param ctx the parse tree
	 */
	void exitPathAbsolute(HTTPMessageParser.PathAbsoluteContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTTPMessageParser#pathEmpty}.
	 * @param ctx the parse tree
	 */
	void enterPathEmpty(HTTPMessageParser.PathEmptyContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTTPMessageParser#pathEmpty}.
	 * @param ctx the parse tree
	 */
	void exitPathEmpty(HTTPMessageParser.PathEmptyContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTTPMessageParser#segmentNz}.
	 * @param ctx the parse tree
	 */
	void enterSegmentNz(HTTPMessageParser.SegmentNzContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTTPMessageParser#segmentNz}.
	 * @param ctx the parse tree
	 */
	void exitSegmentNz(HTTPMessageParser.SegmentNzContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTTPMessageParser#port}.
	 * @param ctx the parse tree
	 */
	void enterPort(HTTPMessageParser.PortContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTTPMessageParser#port}.
	 * @param ctx the parse tree
	 */
	void exitPort(HTTPMessageParser.PortContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTTPMessageParser#userinfo}.
	 * @param ctx the parse tree
	 */
	void enterUserinfo(HTTPMessageParser.UserinfoContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTTPMessageParser#userinfo}.
	 * @param ctx the parse tree
	 */
	void exitUserinfo(HTTPMessageParser.UserinfoContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTTPMessageParser#host}.
	 * @param ctx the parse tree
	 */
	void enterHost(HTTPMessageParser.HostContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTTPMessageParser#host}.
	 * @param ctx the parse tree
	 */
	void exitHost(HTTPMessageParser.HostContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTTPMessageParser#ipv4address}.
	 * @param ctx the parse tree
	 */
	void enterIpv4address(HTTPMessageParser.Ipv4addressContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTTPMessageParser#ipv4address}.
	 * @param ctx the parse tree
	 */
	void exitIpv4address(HTTPMessageParser.Ipv4addressContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTTPMessageParser#decOctet}.
	 * @param ctx the parse tree
	 */
	void enterDecOctet(HTTPMessageParser.DecOctetContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTTPMessageParser#decOctet}.
	 * @param ctx the parse tree
	 */
	void exitDecOctet(HTTPMessageParser.DecOctetContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTTPMessageParser#ipLiteral}.
	 * @param ctx the parse tree
	 */
	void enterIpLiteral(HTTPMessageParser.IpLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTTPMessageParser#ipLiteral}.
	 * @param ctx the parse tree
	 */
	void exitIpLiteral(HTTPMessageParser.IpLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTTPMessageParser#ipvFuture}.
	 * @param ctx the parse tree
	 */
	void enterIpvFuture(HTTPMessageParser.IpvFutureContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTTPMessageParser#ipvFuture}.
	 * @param ctx the parse tree
	 */
	void exitIpvFuture(HTTPMessageParser.IpvFutureContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTTPMessageParser#ipv6address}.
	 * @param ctx the parse tree
	 */
	void enterIpv6address(HTTPMessageParser.Ipv6addressContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTTPMessageParser#ipv6address}.
	 * @param ctx the parse tree
	 */
	void exitIpv6address(HTTPMessageParser.Ipv6addressContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTTPMessageParser#ls32}.
	 * @param ctx the parse tree
	 */
	void enterLs32(HTTPMessageParser.Ls32Context ctx);
	/**
	 * Exit a parse tree produced by {@link HTTPMessageParser#ls32}.
	 * @param ctx the parse tree
	 */
	void exitLs32(HTTPMessageParser.Ls32Context ctx);
	/**
	 * Enter a parse tree produced by {@link HTTPMessageParser#h16}.
	 * @param ctx the parse tree
	 */
	void enterH16(HTTPMessageParser.H16Context ctx);
	/**
	 * Exit a parse tree produced by {@link HTTPMessageParser#h16}.
	 * @param ctx the parse tree
	 */
	void exitH16(HTTPMessageParser.H16Context ctx);
	/**
	 * Enter a parse tree produced by {@link HTTPMessageParser#regName}.
	 * @param ctx the parse tree
	 */
	void enterRegName(HTTPMessageParser.RegNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTTPMessageParser#regName}.
	 * @param ctx the parse tree
	 */
	void exitRegName(HTTPMessageParser.RegNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTTPMessageParser#messageBody}.
	 * @param ctx the parse tree
	 */
	void enterMessageBody(HTTPMessageParser.MessageBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTTPMessageParser#messageBody}.
	 * @param ctx the parse tree
	 */
	void exitMessageBody(HTTPMessageParser.MessageBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTTPMessageParser#headerField}.
	 * @param ctx the parse tree
	 */
	void enterHeaderField(HTTPMessageParser.HeaderFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTTPMessageParser#headerField}.
	 * @param ctx the parse tree
	 */
	void exitHeaderField(HTTPMessageParser.HeaderFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTTPMessageParser#fieldValue}.
	 * @param ctx the parse tree
	 */
	void enterFieldValue(HTTPMessageParser.FieldValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTTPMessageParser#fieldValue}.
	 * @param ctx the parse tree
	 */
	void exitFieldValue(HTTPMessageParser.FieldValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTTPMessageParser#obsFold}.
	 * @param ctx the parse tree
	 */
	void enterObsFold(HTTPMessageParser.ObsFoldContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTTPMessageParser#obsFold}.
	 * @param ctx the parse tree
	 */
	void exitObsFold(HTTPMessageParser.ObsFoldContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTTPMessageParser#fieldContent}.
	 * @param ctx the parse tree
	 */
	void enterFieldContent(HTTPMessageParser.FieldContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTTPMessageParser#fieldContent}.
	 * @param ctx the parse tree
	 */
	void exitFieldContent(HTTPMessageParser.FieldContentContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTTPMessageParser#fieldvchar}.
	 * @param ctx the parse tree
	 */
	void enterFieldvchar(HTTPMessageParser.FieldvcharContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTTPMessageParser#fieldvchar}.
	 * @param ctx the parse tree
	 */
	void exitFieldvchar(HTTPMessageParser.FieldvcharContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTTPMessageParser#ws}.
	 * @param ctx the parse tree
	 */
	void enterWs(HTTPMessageParser.WsContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTTPMessageParser#ws}.
	 * @param ctx the parse tree
	 */
	void exitWs(HTTPMessageParser.WsContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTTPMessageParser#hexdig}.
	 * @param ctx the parse tree
	 */
	void enterHexdig(HTTPMessageParser.HexdigContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTTPMessageParser#hexdig}.
	 * @param ctx the parse tree
	 */
	void exitHexdig(HTTPMessageParser.HexdigContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTTPMessageParser#octet}.
	 * @param ctx the parse tree
	 */
	void enterOctet(HTTPMessageParser.OctetContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTTPMessageParser#octet}.
	 * @param ctx the parse tree
	 */
	void exitOctet(HTTPMessageParser.OctetContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTTPMessageParser#alpha}.
	 * @param ctx the parse tree
	 */
	void enterAlpha(HTTPMessageParser.AlphaContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTTPMessageParser#alpha}.
	 * @param ctx the parse tree
	 */
	void exitAlpha(HTTPMessageParser.AlphaContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTTPMessageParser#vchar}.
	 * @param ctx the parse tree
	 */
	void enterVchar(HTTPMessageParser.VcharContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTTPMessageParser#vchar}.
	 * @param ctx the parse tree
	 */
	void exitVchar(HTTPMessageParser.VcharContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTTPMessageParser#subDelims}.
	 * @param ctx the parse tree
	 */
	void enterSubDelims(HTTPMessageParser.SubDelimsContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTTPMessageParser#subDelims}.
	 * @param ctx the parse tree
	 */
	void exitSubDelims(HTTPMessageParser.SubDelimsContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTTPMessageParser#atzl}.
	 * @param ctx the parse tree
	 */
	void enterAtzl(HTTPMessageParser.AtzlContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTTPMessageParser#atzl}.
	 * @param ctx the parse tree
	 */
	void exitAtzl(HTTPMessageParser.AtzlContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTTPMessageParser#digit}.
	 * @param ctx the parse tree
	 */
	void enterDigit(HTTPMessageParser.DigitContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTTPMessageParser#digit}.
	 * @param ctx the parse tree
	 */
	void exitDigit(HTTPMessageParser.DigitContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTTPMessageParser#fieldName}.
	 * @param ctx the parse tree
	 */
	void enterFieldName(HTTPMessageParser.FieldNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTTPMessageParser#fieldName}.
	 * @param ctx the parse tree
	 */
	void exitFieldName(HTTPMessageParser.FieldNameContext ctx);
}