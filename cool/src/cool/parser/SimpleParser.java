package cool.parser;

import java.util.ArrayList;
import beaver.*;
import cool.parser.ast.*;

/**
 * This class is a LALR parser generated by
 * <a href="http://beaver.sourceforge.net">Beaver</a> v0.9.6.1
 * from the grammar specification "cool.grammar".
 */
public class SimpleParser extends Parser {

	static final ParsingTables PARSING_TABLES = new ParsingTables(
		"U9pjc0UKLSKPn$$tljstiXhK1G4BiWWgAWjXLL1GM8eKDKP9x8c9FHOIaLWIOpIsgB7492O" +
		"nzfw6W295fIWMK74HL1ICYHfBD9eeMB1a$4sxx#xk0nQE9yTpvCtvVss#RxwPR#QzU#T9nG" +
		"lC$KsRYhefIECqI7rC8rA5AlLxVIVpgTPm3KDw8Ml6KlLKqUkwZBX6ymdIDKIdn4RF$n7xB" +
		"VXBiQdW#7XpRz2lrNek#YNTh0akR$Hj9FO8RMcUZ4rj7B$Rp0#wpxi4wHgDD9zQAVHih0te" +
		"UL9Z6QLAGtMGQdISZj9tjQ6#eZ4wLSUgXvcl7#hx#e5EOlK$LH$jhbhLcmMnQMD7rrVRO9d" +
		"1AEtCFTWsr4Rm#pBFSJgPwYqmpsUjqLET5$HxT14HqwraPfZfQXyzYJs5sEVDts9JBqTxCu" +
		"QtJDU1H4vpqYPc6ZMAlhP6Ly6NPcsMfpecwDDq1#ZWf74waqp1K#CrLeV1X#feQcIhCr7xw" +
		"zPO7NLiLfqpN7N#4PikTNGBPkdrMvZbRAVDrc6wH9qotqPzMrsXvxlzQbGtROrlOz3#52Kp" +
		"KvkPoMPcqDw8ZLbQVfUk3$gHkb4Nc8b8FpSJjPssppp7cZlC90rrb1MPnxM3TivMr3Eko4m" +
		"mZsb7Cy6kI7kPP$LBtGRzjMutpz8UrM3pk9Dewfb9GxI7zZIF1VqvCzSydD7djBU#PXwraj" +
		"FsYPAPfw#RPyoyeBsPjKSyrJUzhc$e01siGv0EDK#PXJhSMHiqcbeiqWbKwZJcOYjskhcJq" +
		"nJhTs4cNQnVw7BzAkYBTQMkWrwXtvd5yD$e3xhQIgvDoQI7gCiDPaxG6irKym3qGRZR7VrH" +
		"Vyuo$2MJ$ggxD4cJWtQYcKhjfseAjP#gkzrfkbDJDIsh$VJiDDsZUpL3zxlJzA$OT9#ZCpK" +
		"hwBFrWEReGQI7zB0UqQEPxsknQQwZy$HOq1$N4vglHgG5UbABz5Jc#tfiUiRHXNewM9wG#s" +
		"1Jb49xDJPiZdhk9Q#LfD1UYGsRevvxoMibARH$neRDKS#zvBMI5DhBiM5pr7ClUQqa8JT0I" +
		"x$1yjHpBtcj98NsOcpO7FNSIruhISWDqB$7XirHpxtajP8KMgFJ0lNSIruhIVaUVh$iPwYZ" +
		"ziJvJpnnoavSzBFVzY#3N$pORzXRiL4rHpttajTA4d93gwkQp$Bls1Z5KS#zvBMIXDnG#Xt" +
		"4ugZdNl9QINA$Wsiph$$6nYYEUkubhsN#0$KJyv$Ow77KSozvhOd$sx7HuwZdI66spkPdY$" +
		"ygzdHrgrhdLzwli$RZtUGi$KZdwdlQLlrqZddNlAiVEofFFVUI##m6wimxvXtyB9Mdddif#" +
		"9N6LnX$ypAs4JdRfi7MtOrGieyAzctAn7#rZAslUS#ynunoDF3#PRptDSlCClfpDF1otiUR" +
		"vMOv$JaQU3dlt$86cBTrmTRKibKBoqxgPpum7p1gZlBPHMURZyt7M39gLfWLI1ar7vcFa39" +
		"gFZGV8fMeVn$rcNOrxvltiMVKF6sUHYhHlFVFCcs04cug1NVRAVB#kvxgQEjh0#u7FUmx9R" +
		"qrh6eNUkju5#x4lcx6TtX7LhPbBbOkjaqMsnd$BbXhN4rsoSMgHUm85xidke$jnczMqUMru" +
		"nLN6RkxYxMPOjvkQAdBwsSLO#r82R4shZjojVeoVhNQijS3eDnbk2zrLpkrroRg45Q$0#Ty" +
		"Yro#EfTlK3PNCOhFPqUniuxvV7n#hecBhI1hd6jrDbS$ezN7fbbiLHRRi9eQnTZwBBQEsAu" +
		"krcUAiRiIKKTiKIEPaQtEjjmRXcNLgMrLTRREPcap9$JKW3f#HRRCCXKOjmrvXkDhyoJ4LM" +
		"LvEcTv4aQj9DhcwTmYKoKpyfbs9cj2ivago52TosJjHMUtcOhK8SaojSbbAgB5J0LNmI9LY" +
		"b7LdAoMKVNCg9AU6DKqLpNntSfKpvx3SgkAErKCgnf2JrVYQlYrJ6dRv5QLkaorvB6Pwl6h" +
		"pZBjbcMoqTMCN5hLAAAsncAZQjtiOrINBCfMeXuQer9atsnKPyv9ALVNBAgMdkwSgRWg6zc" +
		"5N4LiNLnaDsBQPf4RPP5Lh6Wz8fgUfirTDRR0qrUZZVj#TNLxREjNarMZ5BEDYzaKpSTqX7" +
		"T2ga5knmpQbudfu69gcKduJXltKOq9dvOns8XnVIucyrmNytd559nMT9Ip4th3sK4APoUB2" +
		"sUrTL7HpqLz2VoQL6dDTsDjzcBDitmnv$Mv#MTxLHDdw$nNkgUhMzKwlvNunNUJdhmbz59l" +
		"RXLzMhUBsgCrVgNnqUBugxHfSBIv4KhseQsBpzcO7rgvq$N$zcvfQurbPJcQsTTORvffpRn" +
		"B#o4jFjlVUEt$eDr0Bt20kw#9cxRm4wT4l6U8UxTq96WBhWBNWpt1hU76VWwu5qm4Im4tiw" +
		"GJg01xeTy0tniSZ3n0Ad2xBmv1tmdvT3XouH8uj$G2laN6Bev6tmyS3aubpiQU0XQwIgem6" +
		"Td#btC5$MUYpuLpuoiyJ#mXeAzKSQTK#GpyOVZ9y2NWDF0sVjmjauk1ZQy5h3kv3kmFnhWR" +
		"hP8BmJNWPd0Bk0nS2QvbZ0tXKy5iy23vZYE66sWo7zd#bq6#P0AO1CQ3Pq4Fi10i0jpN4#g" +
		"LKjDa85ZY$ZkGY15Zw4tc$1RzEz37cj8HW5gaPm3caEANpiCdXRyCFaNkmBewuZyBB4RkW#" +
		"q2m5vMN0udJmNZLGm3jwDJuwBTezvW7t9IquIzIUO0zZ4v6Zm15e2J0EjApWMl0Sv8OjTh$" +
		"qsS2Ny1FCUuXyBPVp7dmYXavfLmxqytWhyA1Y6JCxNphWAyXQQsbdN0rioUWxF09#0s#ZQ6" +
		"izyfTzo4EIVJmKFWKcm5q0wq0KNG7gmFg7FAcbF6J3blwNQW7d2#KivSsW0uZobrIFS5x7d" +
		"Q3t3#qzt1WM0muFobdD#Kiv0U13Y3AJL9Zm77WYC0zKfF17m$KcgKdW0kijyjZkb7bWTvQP" +
		"J3zsuhRDH8XmPzHAxl#BnliDtOLAySszmds9Vdv4y3Fp$mArhw9oD2t#1StDLDVOh5OByrP" +
		"niG#C5XVaU5TRwI6tjCiBsU6$kCSlDkjeRxScDS4iPVkd9$tZIKL9MnTyVUAyXpokHPjEfv" +
		"wBoSV5DkJfDozcM1BsuQMnpTRAmLkVWxLfLtvVEfV2CttfIM$Sc4m9Sqops$cT#BQvF$YuB" +
		"m6SqJAE5fbOB4oNrudx7Fzjuy#Nfps#tjv0BFueY4frp1FJLxmZqIdeU5W8JdOo70ocdWIJ" +
		"FTyWhdDvAPZCHc$ptS7huJV4Vi7WbFnwA6kF#0ga0bI7WALu24TpQ#zUx$LlllNWeA8D4mX" +
		"uBZk#8xaBw1oAFWe#3rzDdtjpq27mGVG9$zXxC$xulz6Qy$#VeJsnURnU201do7muS7lXjy" +
		"hyy0QB7moG==");

	public SimpleParser() {
		super(PARSING_TABLES);
	}

	protected Symbol invokeReduceAction(int rule_num, int offset) {
		switch(rule_num) {
			case 0: // program = class_list.cl
			{
					final Symbol _symbol_cl = _symbols[offset + 1];
					final ArrayList cl = (ArrayList) _symbol_cl.value;
					 return new Symbol(cl);
			}
			case 1: // class_list = classdecl.cd class_list.cl
			{
					final Symbol cd = _symbols[offset + 1];
					final Symbol _symbol_cl = _symbols[offset + 2];
					final ArrayList cl = (ArrayList) _symbol_cl.value;
					 cl.add(cd); return new Symbol(cl);
			}
			case 2: // class_list = empty
			{
					 return new Symbol( new ArrayList() );
			}
			case 4: // expr = lexpr.le ASSIGN rexpr.re
			{
					final Symbol le = _symbols[offset + 1];
					final Symbol _symbol_re = _symbols[offset + 3];
					final Expr re = (Expr) _symbol_re.value;
					 ArrayList operands = new ArrayList(); operands.add(le); operands.add(re); return new AssignmentOperation(operands);
			}
			case 5: // expr = rexpr.r
			{
					final Symbol _symbol_r = _symbols[offset + 1];
					final Expr r = (Expr) _symbol_r.value;
					 return r;
			}
			case 6: // rexpr = IF LPAREN rexpr.cond RPAREN expr.m ELSE expr.e
			{
					final Symbol _symbol_cond = _symbols[offset + 3];
					final Expr cond = (Expr) _symbol_cond.value;
					final Symbol _symbol_m = _symbols[offset + 5];
					final Expr m = (Expr) _symbol_m.value;
					final Symbol _symbol_e = _symbols[offset + 7];
					final Expr e = (Expr) _symbol_e.value;
					 return new IfNode( cond, m, e);
			}
			case 7: // rexpr = WHILE LPAREN rexpr.cond RPAREN expr.e
			{
					final Symbol _symbol_cond = _symbols[offset + 3];
					final Expr cond = (Expr) _symbol_cond.value;
					final Symbol _symbol_e = _symbols[offset + 5];
					final Expr e = (Expr) _symbol_e.value;
					 return new WhileNode( cond, e);
			}
			case 8: // rexpr = rel.r
			{
					final Symbol r = _symbols[offset + 1];
					 return r;
			}
			case 9: // rexpr = primary.p MATCH cases.c
			{
					final Symbol p = _symbols[offset + 1];
					final Symbol _symbol_c = _symbols[offset + 3];
					final ArrayList c = (ArrayList) _symbol_c.value;
					 Expr e = (Expr) p.value; return new Match(e, c);
			}
			case 10: // rel = rel.r LE equiv.e
			{
					final Symbol r = _symbols[offset + 1];
					final Symbol e = _symbols[offset + 3];
					  ArrayList operands = new ArrayList(); operands.add(r); operands.add(e); return new LessOrEqual(operands);
			}
			case 11: // rel = rel.r LT equiv.e
			{
					final Symbol r = _symbols[offset + 1];
					final Symbol e = _symbols[offset + 3];
					  ArrayList operands = new ArrayList(); operands.add(r); operands.add(e); return new LessThan(operands);
			}
			case 12: // rel = equiv.e
			{
					final Symbol e = _symbols[offset + 1];
					 return e;
			}
			case 13: // equiv = equiv.e EQUALS sum.s
			{
					final Symbol e = _symbols[offset + 1];
					final Symbol s = _symbols[offset + 3];
					  ArrayList operands = new ArrayList(); operands.add(e); operands.add(s); return new Equal(operands);
			}
			case 14: // equiv = sum.s
			{
					final Symbol s = _symbols[offset + 1];
					 return s;
			}
			case 15: // sum = sum.s PLUS product.p
			{
					final Symbol s = _symbols[offset + 1];
					final Symbol p = _symbols[offset + 3];
					 ArrayList operands = new ArrayList(); operands.add(s); operands.add(p); return new PlusOperation(operands);
			}
			case 16: // sum = sum.s MINUS product.p
			{
					final Symbol s = _symbols[offset + 1];
					final Symbol p = _symbols[offset + 3];
					 ArrayList operands = new ArrayList(); operands.add(s); operands.add(p); return new MinusOperation(operands);
			}
			case 17: // sum = product.p
			{
					final Symbol p = _symbols[offset + 1];
					 return p;
			}
			case 18: // product = product.p TIMES primary.i
			{
					final Symbol p = _symbols[offset + 1];
					final Symbol i = _symbols[offset + 3];
					 ArrayList operands = new ArrayList(); operands.add(p); operands.add(i); return new MultiplyOperation(operands);
			}
			case 19: // product = product.p DIV primary.i
			{
					final Symbol p = _symbols[offset + 1];
					final Symbol i = _symbols[offset + 3];
					 ArrayList operands = new ArrayList(); operands.add(p); operands.add(i); return new DivisionOperation(operands);
			}
			case 20: // product = primary.p
			{
					final Symbol p = _symbols[offset + 1];
					 return p;
			}
			case 21: // primary = LBRACE block.b RBRACE
			{
					final Symbol _symbol_b = _symbols[offset + 2];
					final Block b = (Block) _symbol_b.value;
					 return (Expr)b;
			}
			case 22: // primary = LPAREN expr.e RPAREN
			{
					final Symbol _symbol_e = _symbols[offset + 2];
					final Expr e = (Expr) _symbol_e.value;
					 return e;
			}
			case 23: // primary = NULL
			{
					 return new NullNode();
			}
			case 24: // primary = LPAREN RPAREN
			{
					 return new Unit();
			}
			case 25: // primary = INTEGER.i
			{
					final Symbol _symbol_i = _symbols[offset + 1];
					final String i = (String) _symbol_i.value;
					 return new IntegerNode(Integer.parseInt(i));
			}
			case 26: // primary = STRING.s
			{
					final Symbol _symbol_s = _symbols[offset + 1];
					final String s = (String) _symbol_s.value;
					 return new StringNode(s);
			}
			case 27: // primary = BOOLEAN.b
			{
					final Symbol _symbol_b = _symbols[offset + 1];
					final Boolean b = (Boolean) _symbol_b.value;
					 return new BooleanNode(b);
			}
			case 28: // primary = MINUS primary.p
			{
					final Symbol p = _symbols[offset + 2];
					 ArrayList operands = new ArrayList() ; operands.add(p); return new UnaryRealOperation(operands);
			}
			case 29: // primary = lexpr.e
			{
					final Symbol e = _symbols[offset + 1];
					 return e;
			}
			case 30: // primary = NOT primary.p
			{
					final Symbol p = _symbols[offset + 2];
					 ArrayList operands = new ArrayList() ; operands.add(p); return new UnaryBooleanOperation(operands);
			}
			case 31: // primary = primary DOT ID actuals.a
			{
					final Symbol _symbol_a = _symbols[offset + 4];
					final ArrayList a = (ArrayList) _symbol_a.value;
					 return new PrimaryActual(a);
			}
			case 32: // primary = NEW TYPE.t actuals.s
			{
					final Symbol _symbol_t = _symbols[offset + 2];
					final String t = (String) _symbol_t.value;
					final Symbol _symbol_s = _symbols[offset + 3];
					final ArrayList s = (ArrayList) _symbol_s.value;
					 return new Instance(t,s);
			}
			case 35: // ident = ID.id opt$actuals
			{
					final Symbol _symbol_id = _symbols[offset + 1];
					final String id = (String) _symbol_id.value;
					 return new Id(id);
			}
			case 36: // ident = THIS
			{
					 return new Id("this");
			}
			case 37: // block = st_list.el expr.e
			{
					final Symbol el = _symbols[offset + 1];
					final Symbol _symbol_e = _symbols[offset + 2];
					final Expr e = (Expr) _symbol_e.value;
					 ArrayList es = (ArrayList) el.value; return new Block(es , e);
			}
			case 38: // st_list = st_list.el new_var.ve SEMI
			{
					final Symbol el = _symbols[offset + 1];
					final Symbol ve = _symbols[offset + 2];
					 ArrayList es = (ArrayList) el.value; es.add(ve); return new Symbol(es);
			}
			case 39: // st_list = st_list.el expr.e SEMI
			{
					final Symbol el = _symbols[offset + 1];
					final Symbol _symbol_e = _symbols[offset + 2];
					final Expr e = (Expr) _symbol_e.value;
					 ArrayList es = (ArrayList) el.value; es.add(e); return new Symbol(es);
			}
			case 40: // st_list = empty
			{
					 ArrayList el  = new ArrayList(); return new Symbol(el);
			}
			case 41: // new_var = VAR ID.id COLON TYPE.t ASSIGN expr.e
			{
					final Symbol _symbol_id = _symbols[offset + 2];
					final String id = (String) _symbol_id.value;
					final Symbol _symbol_t = _symbols[offset + 4];
					final String t = (String) _symbol_t.value;
					final Symbol _symbol_e = _symbols[offset + 6];
					final Expr e = (Expr) _symbol_e.value;
					 return new VarExpr( id, t, e);
			}
			case 42: // cases = LBRACE case_block.cb RBRACE
			{
					final Symbol _symbol_cb = _symbols[offset + 2];
					final ArrayList cb = (ArrayList) _symbol_cb.value;
					 return new Symbol(cb);
			}
			case 43: // case_block = CASE ID.id COLON TYPE.t ARROW block.b case_block.cb
			{
					final Symbol _symbol_id = _symbols[offset + 2];
					final String id = (String) _symbol_id.value;
					final Symbol _symbol_t = _symbols[offset + 4];
					final String t = (String) _symbol_t.value;
					final Symbol _symbol_b = _symbols[offset + 6];
					final Block b = (Block) _symbol_b.value;
					final Symbol _symbol_cb = _symbols[offset + 7];
					final ArrayList cb = (ArrayList) _symbol_cb.value;
					 cb.add(new Case(id,t,b));return new Symbol(cb);
			}
			case 44: // case_block = CASE NULL ARROW block.b case_block.cb
			{
					final Symbol _symbol_b = _symbols[offset + 4];
					final Block b = (Block) _symbol_b.value;
					final Symbol _symbol_cb = _symbols[offset + 5];
					final ArrayList cb = (ArrayList) _symbol_cb.value;
					 cb.add(new Case(b));return new Symbol(cb);
			}
			case 45: // case_block = empty
			{
					 return new Symbol(new ArrayList());
			}
			case 46: // lexpr = SUPER DOT ID actuals.a
			{
					final Symbol _symbol_a = _symbols[offset + 4];
					final ArrayList a = (ArrayList) _symbol_a.value;
					 return new SuperActual(a);
			}
			case 47: // lexpr = ident.id
			{
					final Symbol _symbol_id = _symbols[offset + 1];
					final Id id = (Id) _symbol_id.value;
					 return id;
			}
			case 50: // classdecl = CLASS TYPE.t varformals.v have_extends.e classbody.fl
			{
					final Symbol _symbol_t = _symbols[offset + 2];
					final String t = (String) _symbol_t.value;
					final Symbol _symbol_v = _symbols[offset + 3];
					final ArrayList v = (ArrayList) _symbol_v.value;
					final Symbol _symbol_e = _symbols[offset + 4];
					final Extends e = (Extends) _symbol_e.value;
					final Symbol fl = _symbols[offset + 5];
					 return new ClassNode(t, v, e, (ArrayList)fl.value);
			}
			case 51: // varformals = LPAREN RPAREN
			{
					 return new Symbol(new ArrayList());
			}
			case 52: // varformals = LPAREN var_list.vl RPAREN
			{
					final Symbol _symbol_vl = _symbols[offset + 2];
					final ArrayList vl = (ArrayList) _symbol_vl.value;
					 return new Symbol(vl);
			}
			case 53: // varformals = empty
			{
					 return new Symbol(new ArrayList());
			}
			case 54: // var_list = one_var.v
			{
					final Symbol _symbol_v = _symbols[offset + 1];
					final Var v = (Var) _symbol_v.value;
					 ArrayList vl = new ArrayList(); vl.add(v); return new Symbol(vl);
			}
			case 55: // var_list = var_list.vl COMMA one_var.v
			{
					final Symbol _symbol_vl = _symbols[offset + 1];
					final ArrayList vl = (ArrayList) _symbol_vl.value;
					final Symbol _symbol_v = _symbols[offset + 3];
					final Var v = (Var) _symbol_v.value;
					 vl.add(v); return new Symbol(vl);
			}
			case 56: // var_list = empty
			{
					 new Symbol( new ArrayList() );
			}
			case 57: // one_var = VAR ID.id COLON TYPE.t
			{
					final Symbol _symbol_id = _symbols[offset + 2];
					final String id = (String) _symbol_id.value;
					final Symbol _symbol_t = _symbols[offset + 4];
					final String t = (String) _symbol_t.value;
					 return new Var(id, t);
			}
			case 58: // have_extends = EXTENDS type_or_native.ext
			{
					final Symbol ext = _symbols[offset + 2];
					 return ext;
			}
			case 60: // type_or_native = TYPE.t actuals.a
			{
					final Symbol _symbol_t = _symbols[offset + 1];
					final String t = (String) _symbol_t.value;
					final Symbol _symbol_a = _symbols[offset + 2];
					final ArrayList a = (ArrayList) _symbol_a.value;
					 return new Extends(t, a);
			}
			case 61: // type_or_native = NATIVE
			{
					 return new Extends();
			}
			case 62: // actuals = LPAREN exp_list.el RPAREN
			{
					final Symbol _symbol_el = _symbols[offset + 2];
					final ArrayList el = (ArrayList) _symbol_el.value;
					 return new Symbol(el);
			}
			case 63: // exp_list = expr.e
			{
					final Symbol _symbol_e = _symbols[offset + 1];
					final Expr e = (Expr) _symbol_e.value;
					 ArrayList el = new ArrayList(); el.add(e); return new Symbol(el);
			}
			case 64: // exp_list = exp_list.el COMMA expr.e
			{
					final Symbol _symbol_el = _symbols[offset + 1];
					final ArrayList el = (ArrayList) _symbol_el.value;
					final Symbol _symbol_e = _symbols[offset + 3];
					final Expr e = (Expr) _symbol_e.value;
					 el.add(e); return new Symbol(el);
			}
			case 65: // exp_list = empty
			{
					 return new Symbol( new ArrayList() );
			}
			case 66: // classbody = LBRACE feature_list.fl RBRACE
			{
					final Symbol _symbol_fl = _symbols[offset + 2];
					final ArrayList fl = (ArrayList) _symbol_fl.value;
					 return new Symbol(fl);
			}
			case 67: // feature_list = feature.f feature_list.fl
			{
					final Symbol _symbol_f = _symbols[offset + 1];
					final Feature f = (Feature) _symbol_f.value;
					final Symbol _symbol_fl = _symbols[offset + 2];
					final ArrayList fl = (ArrayList) _symbol_fl.value;
					 fl.add(f); return new Symbol(fl);
			}
			case 68: // feature_list = empty
			{
					 return new Symbol( new ArrayList() );
			}
			case 69: // feature = overridable DEF ID.id formals.fl COLON TYPE.t ASSIGN expr_or_native.e SEMI
			{
					final Symbol _symbol_id = _symbols[offset + 3];
					final String id = (String) _symbol_id.value;
					final Symbol fl = _symbols[offset + 4];
					final Symbol _symbol_t = _symbols[offset + 6];
					final String t = (String) _symbol_t.value;
					final Symbol e = _symbols[offset + 8];
					 return new FeatureMethod(id, (ArrayList)fl.value, t, (Expr)e);
			}
			case 70: // feature = VAR ID.id ASSIGN NATIVE SEMI
			{
					final Symbol _symbol_id = _symbols[offset + 2];
					final String id = (String) _symbol_id.value;
					 return new FeatureVar(id );
			}
			case 71: // feature = VAR ID.id COLON TYPE.t ASSIGN expr.e SEMI
			{
					final Symbol _symbol_id = _symbols[offset + 2];
					final String id = (String) _symbol_id.value;
					final Symbol _symbol_t = _symbols[offset + 4];
					final String t = (String) _symbol_t.value;
					final Symbol _symbol_e = _symbols[offset + 6];
					final Expr e = (Expr) _symbol_e.value;
					 return new FeatureVar(id, t, e );
			}
			case 72: // feature = LBRACE block.b RBRACE SEMI
			{
					final Symbol _symbol_b = _symbols[offset + 2];
					final Block b = (Block) _symbol_b.value;
					 return new FeatureBlock(b);
			}
			case 75: // expr_or_native = expr.e
			{
					final Symbol _symbol_e = _symbols[offset + 1];
					final Expr e = (Expr) _symbol_e.value;
					 return e;
			}
			case 77: // formals = LPAREN formal_list.fl RPAREN
			{
					final Symbol _symbol_fl = _symbols[offset + 2];
					final ArrayList fl = (ArrayList) _symbol_fl.value;
					 return new Symbol(fl);
			}
			case 78: // formal_list = formal.f
			{
					final Symbol _symbol_f = _symbols[offset + 1];
					final Formal f = (Formal) _symbol_f.value;
					 ArrayList fl = new ArrayList(); fl.add(f); return new Symbol(fl);
			}
			case 79: // formal_list = formal_list.fl COMMA formal.f
			{
					final Symbol _symbol_fl = _symbols[offset + 1];
					final ArrayList fl = (ArrayList) _symbol_fl.value;
					final Symbol _symbol_f = _symbols[offset + 3];
					final Formal f = (Formal) _symbol_f.value;
					 fl.add(f); return new Symbol(fl);
			}
			case 80: // formal_list = empty
			{
					 return new Symbol( new ArrayList() );
			}
			case 81: // formal = ID.id COLON TYPE.t
			{
					final Symbol _symbol_id = _symbols[offset + 1];
					final String id = (String) _symbol_id.value;
					final Symbol _symbol_t = _symbols[offset + 3];
					final String t = (String) _symbol_t.value;
					  return new Formal(id,t);
			}
			case 33: // opt$actuals = 
			case 48: // empty = 
			{
				return new Symbol(null);
			}
			case 3: // program = bogus
			case 34: // opt$actuals = actuals
			case 59: // have_extends = empty
			case 73: // overridable = OVERRIDE
			case 74: // overridable = empty
			case 76: // expr_or_native = NATIVE
			{
				return _symbols[offset + 1];
			}
			case 49: // bogus = STUB CLASS EXTENDS VAR OVERRIDE DEF NATIVE NEW NULL THIS CASE MATCH IF ELSE WHILE SUPER LPAREN RPAREN LBRACE RBRACE COLON COMMA ASSIGN SEMI ARROW DOT PLUS MINUS TIMES DIV LE LT EQUALS NOT TYPE ID INTEGER STRING BOOLEAN
			{
				return _symbols[offset + 39];
			}
			default:
				throw new IllegalArgumentException("unknown production #" + rule_num);
		}
	}
}
