package com.github.leonchrisdion.loremIpsumGenerator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.github.leonchrisdion.loremIpsumGenerator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // Declaring Ipsums
    private val loremIpsum: Ipsum = Ipsum("Lorem Ipsum", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec bibendum facilisis lacus id varius. Aenean lacinia tempor neque, id vulputate sem blandit ut. Suspendisse imperdiet lorem ante, sed finibus justo aliquam vel. Etiam iaculis orci enim, vel finibus justo consequat vitae. Maecenas tincidunt, felis sed feugiat accumsan, velit augue dictum orci, non venenatis turpis lorem id tortor. In elit sapien, ultricies vel cursus id, rutrum ut massa. Vestibulum congue consequat nunc, a bibendum justo malesuada a. Aenean eu ipsum sed sapien feugiat mattis ac ac neque. Nunc diam erat, varius vel nibh quis, tempor scelerisque enim. Ut faucibus sed urna eget vestibulum. Phasellus semper sed libero non cursus. Nam aliquam metus sed ipsum pellentesque, non lobortis risus aliquet. Sed at molestie elit.\n" +
            "Donec faucibus mauris facilisis velit euismod hendrerit. Interdum et malesuada fames ac ante ipsum primis in faucibus. Vivamus consectetur eget nisi nec suscipit. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Donec tincidunt, ligula vulputate ullamcorper cursus, est turpis tristique ex, non feugiat ipsum lorem quis augue. Nam ut faucibus risus. Pellentesque eget dictum lacus, vel cursus sapien.\n" +
            "Maecenas nec malesuada risus, a tincidunt dolor. Pellentesque vel tincidunt tellus. Mauris eu aliquam ligula. Nam sit amet justo eget neque tincidunt pellentesque. Nulla id accumsan tortor. Phasellus erat enim, convallis et leo et, pretium dapibus est. Fusce eget ipsum rutrum, finibus diam eget, cursus ante. Sed a metus auctor, rutrum lectus vitae, ullamcorper ex. Nullam sit amet tempor tortor, sed vestibulum mi. Cras efficitur ex quis vehicula aliquet. Sed pretium nisl lectus, nec posuere lacus iaculis at. Quisque ut orci eu leo eleifend pellentesque vel ut magna. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Sed eu vestibulum tortor. Vestibulum mollis id diam sit amet feugiat.\n" +
            "Nullam luctus purus id iaculis iaculis. Cras sed egestas lacus, eget pulvinar odio. Fusce non malesuada mi. Quisque pharetra commodo elit in vestibulum. Mauris at felis a enim venenatis mattis non eu arcu. Suspendisse potenti. Nulla ac nibh vitae quam placerat tempor vitae quis metus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Maecenas hendrerit lorem a purus malesuada hendrerit. Nam fringilla purus ac finibus interdum. Nulla quis massa in eros luctus ultrices quis eget lacus. Etiam quis arcu non odio condimentum pharetra. Ut in ultrices felis, nec accumsan arcu. Donec ante lorem, tempor eu elementum id, pellentesque vel arcu. Vestibulum id nisi sed libero suscipit venenatis. Curabitur mi lorem, rhoncus nec rutrum eu, gravida ac erat.\n" +
            "Maecenas luctus facilisis mauris, nec aliquam eros aliquet id. Proin quis tortor ac purus faucibus ullamcorper. Nam vel urna a nibh consectetur mollis. Morbi hendrerit purus sit amet massa volutpat condimentum. In vitae lorem metus. Vivamus condimentum ex viverra orci rutrum faucibus. Praesent ornare lobortis nunc, imperdiet mattis arcu bibendum vel.\n")
    private val cupcakeIpsum: Ipsum = Ipsum("Cupcake Ipsum", "Cupcake ipsum dolor sit amet jelly bear claw danish chocolate. Oat cake icing jelly-o powder cheesecake. Tiramisu tootsie roll sweet roll fruitcake jelly beans lollipop powder candy canes. Cotton candy oat cake wafer oat cake. Macaroon chocolate cake caramels tiramisu donut soufflé liquorice. Candy canes sweet brownie croissant. Powder pastry macaroon bonbon marshmallow muffin. Icing liquorice powder jelly tootsie roll cake lemon drops chupa chups. Sesame snaps jelly beans danish sugar plum gummies topping. Bear claw jujubes caramels sweet roll halvah tart marzipan lollipop. Cheesecake powder marshmallow jujubes cheesecake. Wafer tootsie roll sesame snaps chocolate cake pastry.\n" +
            "\n" +
            "Tootsie roll pastry topping icing apple pie lollipop liquorice marzipan gingerbread. Wafer brownie bonbon powder chupa chups jujubes halvah donut marzipan. Tootsie roll candy canes cake marzipan soufflé. Topping dragée pudding apple pie cupcake cake. Lollipop sugar plum powder jujubes carrot cake chocolate bar cookie. Oat cake caramels muffin muffin. Gingerbread macaroon gingerbread lollipop. Cotton candy soufflé macaroon gingerbread gummi bears tiramisu. Croissant apple pie danish gummi bears powder. Tootsie roll tiramisu carrot cake fruitcake soufflé candy canes croissant jelly. Dessert gingerbread ice cream jelly beans marzipan wafer. Cake sugar plum topping tiramisu. Tart macaroon liquorice cupcake dragée gummies. Tart pudding candy canes lollipop.\n" +
            "\n" +
            "Pastry donut candy canes ice cream chocolate bar cookie. Halvah cake caramels. Pudding bear claw cake candy. Donut ice cream topping macaroon biscuit halvah halvah cake cookie. Cake jelly danish sesame snaps. Macaroon toffee brownie cheesecake. Sesame snaps tiramisu sweet roll dessert cotton candy carrot cake biscuit donut pudding. Toffee marshmallow soufflé marzipan wafer tootsie roll chocolate. Dragée soufflé marzipan lollipop cupcake marshmallow. Apple pie wafer jujubes jelly beans candy. Gummi bears fruitcake topping croissant halvah gummi bears liquorice chocolate cake donut. Marzipan gummi bears muffin. Sesame snaps chocolate cake marzipan pie chocolate bar sweet roll candy.\n" +
            "\n" +
            "Toffee gummi bears donut. Dessert chocolate bar ice cream soufflé cookie jelly beans cake chupa chups bear claw. Lollipop candy canes croissant muffin candy canes chocolate cake pastry topping liquorice. Pudding fruitcake dessert sweet gummi bears lollipop liquorice caramels oat cake. Gummies chupa chups donut toffee oat cake danish macaroon muffin. Pastry gingerbread lollipop jelly beans bonbon topping. Sweet roll candy canes tiramisu wafer marshmallow croissant. Croissant jelly cake gummies jujubes. Danish candy canes pie gingerbread liquorice cake danish. Soufflé cupcake croissant chupa chups gummies jelly-o caramels oat cake dessert. Pastry sweet soufflé gummies marshmallow sesame snaps brownie. Sweet roll lollipop cookie fruitcake jelly-o chocolate cake ice cream gingerbread biscuit. Lemon drops cake chupa chups jelly-o.\n" +
            "\n" +
            "Cupcake macaroon bonbon sweet apple pie. Icing toffee biscuit candy. Cupcake pie marshmallow cupcake jujubes chocolate bar croissant. Donut pie powder lollipop apple pie pastry candy macaroon. Dragée cheesecake jujubes pastry toffee. Caramels gingerbread fruitcake candy canes gummies cheesecake jelly-o dessert. Sweet tiramisu chocolate bar apple pie carrot cake pudding dessert caramels bear claw. Halvah dessert croissant lollipop jelly beans muffin muffin brownie cupcake. Chocolate jelly-o bear claw. Gummi bears tiramisu powder pudding fruitcake tart cake jelly candy canes. Jelly-o carrot cake muffin gummi bears powder. Carrot cake gummi bears jelly-o. Caramels tiramisu marzipan macaroon soufflé gummies tootsie roll powder. Gummies jelly beans oat cake jelly-o candy pudding cake cake.\n" +
            "\n \n")
    private val baconIpsum: Ipsum = Ipsum("Bacon Ipsum", "Bacon ipsum dolor amet boudin jowl sausage, alcatra chuck rump pastrami pork loin beef ribs burgdoggen fatback jerky doner pork belly. Biltong kielbasa meatball t-bone. Beef pork belly flank porchetta hamburger. Doner pig chuck hamburger ham corned beef cupim ball tip alcatra pork loin. Andouille rump bacon beef ribs tongue. Jowl alcatra salami, burgdoggen cupim ham hock brisket doner landjaeger short loin andouille.\n" +
            "\n" +
            "Sausage pork loin pork chop turducken, pancetta meatloaf frankfurter prosciutto biltong brisket corned beef. Buffalo pork shank, venison swine filet mignon biltong tongue. Pancetta bacon prosciutto, drumstick kevin capicola frankfurter beef picanha chicken pork doner sausage tail. Pastrami ball tip filet mignon boudin strip steak, porchetta jerky landjaeger corned beef ham ground round pork belly cupim spare ribs prosciutto. Prosciutto chicken biltong, short ribs filet mignon burgdoggen cupim ground round hamburger. Spare ribs boudin chuck, tri-tip ribeye tongue brisket kevin pork shankle drumstick chicken kielbasa.\n" +
            "\n" +
            "Porchetta t-bone kielbasa, doner spare ribs pastrami cupim meatloaf shoulder. Turkey kevin meatball, fatback filet mignon t-bone beef ribs spare ribs corned beef turducken landjaeger brisket pork loin hamburger meatloaf. Corned beef landjaeger drumstick, ham hock tri-tip leberkas meatball biltong shank. Beef pig pork chop chuck pork belly biltong fatback shankle strip steak shank short loin ham hock spare ribs tongue picanha. Sirloin swine doner leberkas beef hamburger boudin t-bone tail meatball andouille short ribs strip steak bresaola.\n" +
            "\n" +
            "Burgdoggen boudin cupim sirloin, beef ribs ham brisket shoulder porchetta biltong corned beef drumstick meatball. Beef ribs sirloin ham swine, beef porchetta prosciutto tenderloin pork. Landjaeger cow frankfurter pastrami, ham cupim hamburger shank. Shoulder kevin pork chop, pork loin tail tongue turducken bresaola beef ribs pancetta drumstick porchetta. Turkey beef ribs corned beef ball tip cupim kevin pancetta pork chop picanha burgdoggen ground round hamburger. Alcatra tail ground round salami tongue jowl.\n" +
            "\n" +
            "Prosciutto shankle kielbasa strip steak turducken. Boudin porchetta turkey pig alcatra bresaola kielbasa buffalo. Venison spare ribs bresaola, ball tip shankle tail tongue landjaeger shank burgdoggen brisket corned beef ham hock rump sirloin. Turkey meatball prosciutto ham chuck. Jerky drumstick chuck prosciutto.\n" +
            "\n" +
            "Flank pork tail strip steak, tongue beef ribs chuck andouille burgdoggen doner capicola filet mignon shankle ham hock boudin. Corned beef drumstick doner, landjaeger ham porchetta burgdoggen salami pancetta bresaola filet mignon. Burgdoggen venison jowl, alcatra prosciutto drumstick sausage tongue bacon kielbasa picanha. Turducken capicola bacon jerky ham, venison cupim prosciutto beef ribs kielbasa t-bone landjaeger swine fatback.\n" +
            "\n" +
            "Swine burgdoggen turkey hamburger turducken shank pastrami tri-tip pig ham bresaola. Beef boudin hamburger ground round pastrami spare ribs corned beef rump kielbasa landjaeger. Sausage hamburger tongue spare ribs capicola cupim ribeye, fatback turkey tail chuck shoulder meatball bacon corned beef. Meatloaf doner hamburger tri-tip.\n" +
            "\n" +
            "Buffalo sausage jowl brisket biltong venison porchetta pork ball tip frankfurter spare ribs alcatra swine sirloin tongue. Pancetta t-bone hamburger short ribs beef biltong bresaola salami. Biltong strip steak pig rump, prosciutto salami ground round hamburger corned beef beef venison short ribs shoulder pancetta drumstick. Pig venison bacon, alcatra sirloin chicken spare ribs jowl buffalo biltong capicola shoulder pork chuck ham. Buffalo drumstick ball tip tongue swine pork belly turducken landjaeger short loin fatback shank pancetta meatloaf boudin. Porchetta shoulder jowl meatloaf, ball tip short loin pork belly burgdoggen filet mignon prosciutto cupim frankfurter.\n" +
            "\n" +
            "Alcatra rump short ribs frankfurter, pancetta hamburger turkey tongue swine biltong ribeye spare ribs capicola boudin. Alcatra landjaeger corned beef sirloin. Beef ribs ground round porchetta pork chuck turducken. Brisket andouille beef ribs spare ribs, kielbasa buffalo filet mignon pork chop. Beef shank short ribs sirloin pork loin tongue turducken, kevin strip steak cupim doner chuck swine.\n" +
            "\n" +
            "Short loin porchetta turducken flank brisket ball tip buffalo rump pork loin andouille spare ribs strip steak boudin leberkas. Pig salami shankle ball tip venison. Strip steak chicken swine, beef ribs spare ribs landjaeger doner short ribs jowl tenderloin cow venison meatloaf turkey. Corned beef turkey porchetta meatloaf t-bone kielbasa kevin. Rump pastrami prosciutto turkey ham hock. Bresaola ribeye pork tail kielbasa swine.\n" +
            "\n" +
            "Leberkas pancetta cow ground round meatloaf tri-tip filet mignon andouille ham hock meatball spare ribs brisket pork. Strip steak landjaeger hamburger alcatra pig bresaola tri-tip. Landjaeger ribeye beef ribs meatball filet mignon cow sirloin salami strip steak pastrami hamburger bresaola burgdoggen spare ribs. Kevin sausage short ribs ground round venison fatback, ribeye jerky.\n" +
            "\n" +
            "Porchetta meatball doner ribeye, meatloaf bacon pastrami beef ribs cupim chuck. Salami andouille flank shankle tongue, boudin sirloin cupim turducken jowl corned beef. Spare ribs brisket cow drumstick shankle. Filet mignon bresaola shank pig short ribs pork chop ground round fatback meatloaf venison pancetta boudin pork belly salami turducken. Tri-tip turkey boudin shankle. Fatback sirloin sausage hamburger, cow beef buffalo salami drumstick jerky shank ground round flank. Tail biltong turducken, drumstick kielbasa cow fatback tenderloin.\n" +
            "\n" +
            "Beef pig swine meatball shank buffalo pancetta andouille kevin turducken short loin. Corned beef capicola pork bresaola andouille alcatra meatloaf jowl strip steak kevin drumstick fatback tri-tip shank ball tip. Ball tip jowl capicola porchetta, cupim biltong rump corned beef ribeye ham buffalo tri-tip pastrami strip steak spare ribs. Doner flank tongue sausage.\n" +
            "\n" +
            "Shoulder t-bone porchetta alcatra meatloaf pancetta doner. Shank capicola tail ball tip shoulder, spare ribs meatloaf rump. Ham kielbasa boudin capicola corned beef ground round. Beef pork belly pork loin, sausage venison short loin t-bone pork cow ham hock meatloaf jowl ball tip brisket pork chop.\n" +
            "\n" +
            "Corned beef t-bone salami drumstick picanha filet mignon. Burgdoggen chicken leberkas, chuck andouille pork chop alcatra corned beef pork belly frankfurter tongue ham meatloaf ham hock. Brisket bresaola capicola salami pig, beef ribs kielbasa tenderloin chuck tail pork loin buffalo pork chop burgdoggen ball tip. Flank ground round sirloin landjaeger. Jerky t-bone cow, ball tip ribeye short loin prosciutto chuck shank pancetta brisket ham hock. Bacon capicola fatback hamburger cupim chicken tongue brisket meatball landjaeger pork loin. Tongue rump chuck frankfurter shank tri-tip chicken.\n" +
            "\n" +
            "Capicola filet mignon hamburger pork belly picanha short loin. Chicken pork loin filet mignon, jerky beef swine landjaeger tri-tip prosciutto frankfurter capicola pastrami beef ribs spare ribs andouille. Jerky frankfurter andouille corned beef, turkey kevin doner short loin picanha pork chop kielbasa ball tip jowl t-bone. Filet mignon tri-tip flank corned beef pastrami shank short ribs sausage, t-bone pork pork belly tail capicola spare ribs strip steak. Jowl swine fatback, brisket corned beef capicola ball tip meatloaf t-bone turducken pork loin ground round drumstick frankfurter. Bacon leberkas rump, doner boudin kielbasa pork belly bresaola turkey. Pastrami chicken picanha alcatra, corned beef leberkas shoulder andouille prosciutto.\n" +
            "\n" +
            "Kielbasa chicken rump, burgdoggen prosciutto beef pork belly pork loin flank ribeye capicola shoulder brisket frankfurter bresaola. Pig beef ribs picanha ribeye prosciutto short ribs buffalo cow sirloin jowl filet mignon capicola kielbasa jerky. Turducken hamburger venison alcatra brisket meatloaf. Kielbasa shank alcatra shankle filet mignon meatloaf beef bresaola pancetta picanha capicola beef ribs.\n" +
            "\n" +
            "Short loin rump doner chicken hamburger pastrami short ribs. Kielbasa picanha fatback leberkas. Filet mignon tri-tip venison pork short loin jerky pork belly short ribs tenderloin, porchetta leberkas cow tail boudin. Ground round andouille ribeye turkey pork chop jowl, drumstick beef. Pork chop short loin ham beef ribs prosciutto. Leberkas pork sausage pork belly venison rump capicola frankfurter sirloin beef ribs salami fatback chicken ribeye. Pork belly sirloin pig pork chop, short ribs sausage ham prosciutto tenderloin venison landjaeger.\n" +
            "\n" +
            "Boudin chuck tongue beef. Jowl beef ribs landjaeger, venison pastrami capicola doner short ribs frankfurter. Porchetta ham hock rump strip steak hamburger picanha kevin turkey fatback shoulder. Pork frankfurter capicola sirloin, beef ribs pig buffalo filet mignon landjaeger short loin bresaola. Picanha ham pork belly spare ribs capicola ground round. Kevin short ribs ham hock sirloin turkey pig spare ribs salami bresaola andouille. Ribeye shank t-bone short loin.\n" +
            "\n" +
            "Ball tip shoulder chicken ribeye pork chop andouille. Prosciutto salami rump meatball, shankle kielbasa beef ham hock pork loin. Buffalo chicken cow, capicola corned beef jerky pig pork chop pancetta shank venison shoulder. Flank ball tip kevin, chuck picanha cow turkey meatball corned beef. Biltong meatball andouille, picanha corned beef ground round filet mignon drumstick.\n")
    private val veggieIpsum: Ipsum = Ipsum("Veggie Ipsum", "Veggies es bonus vobis, proinde vos postulo essum magis kohlrabi welsh onion daikon amaranth tatsoi tomatillo melon azuki bean garlic.\n" +
            "\n" +
            "Gumbo beet greens corn soko endive gumbo gourd. Parsley shallot courgette tatsoi pea sprouts fava bean collard greens dandelion okra wakame tomato. Dandelion cucumber earthnut pea peanut soko zucchini.\n" +
            "\n" +
            "Turnip greens yarrow ricebean rutabaga endive cauliflower sea lettuce kohlrabi amaranth water spinach avocado daikon napa cabbage asparagus winter purslane kale. Celery potato scallion desert raisin horseradish spinach carrot soko. Lotus root water spinach fennel kombu maize bamboo shoot green bean swiss chard seakale pumpkin onion chickpea gram corn pea. Brussels sprout coriander water chestnut gourd swiss chard wakame kohlrabi beetroot carrot watercress. Corn amaranth salsify bunya nuts nori azuki bean chickweed potato bell pepper artichoke.\n" +
            "\n" +
            "Nori grape silver beet broccoli kombu beet greens fava bean potato quandong celery. Bunya nuts black-eyed pea prairie turnip leek lentil turnip greens parsnip. Sea lettuce lettuce water chestnut eggplant winter purslane fennel azuki bean earthnut pea sierra leone bologi leek soko chicory celtuce parsley jícama salsify.\n" +
            "\n" +
            "Celery quandong swiss chard chicory earthnut pea potato. Salsify taro catsear garlic gram celery bitterleaf wattle seed collard greens nori. Grape wattle seed kombu beetroot horseradish carrot squash brussels sprout chard.\n" +
            "\n" +
            "Pea horseradish azuki bean lettuce avocado asparagus okra. Kohlrabi radish okra azuki bean corn fava bean mustard tigernut jícama green bean celtuce collard greens avocado quandong fennel gumbo black-eyed pea. Grape silver beet watercress potato tigernut corn groundnut. Chickweed okra pea winter purslane coriander yarrow sweet pepper radish garlic brussels sprout groundnut summer purslane earthnut pea tomato spring onion azuki bean gourd. Gumbo kakadu plum komatsuna black-eyed pea green bean zucchini gourd winter purslane silver beet rock melon radish asparagus spinach.\n" +
            "\n" +
            "Beetroot water spinach okra water chestnut ricebean pea catsear courgette summer purslane. Water spinach arugula pea tatsoi aubergine spring onion bush tomato kale radicchio turnip chicory salsify pea sprouts fava bean. Dandelion zucchini burdock yarrow chickpea dandelion sorrel courgette turnip greens tigernut soybean radish artichoke wattle seed endive groundnut broccoli arugula.\n" +
            "\n" +
            "Soko radicchio bunya nuts gram dulse silver beet parsnip napa cabbage lotus root sea lettuce brussels sprout cabbage. Catsear cauliflower garbanzo yarrow salsify chicory garlic bell pepper napa cabbage lettuce tomato kale arugula melon sierra leone bologi rutabaga tigernut. Sea lettuce gumbo grape kale kombu cauliflower salsify kohlrabi okra sea lettuce broccoli celery lotus root carrot winter purslane turnip greens garlic. Jícama garlic courgette coriander radicchio plantain scallion cauliflower fava bean desert raisin spring onion chicory bunya nuts. Sea lettuce water spinach gram fava bean leek dandelion silver beet eggplant bush tomato.\n")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.loremIpsum = loremIpsum
        binding.cupcakeIpsum= cupcakeIpsum
        binding.baconIpsum = baconIpsum
        binding.veggieIpsum= veggieIpsum

        // Populating the Spinner
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.lorem_types, android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.loremTypeSpinner.adapter = adapter

        binding.loremTypeSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val currentType: String = binding.loremTypeSpinner.getItemAtPosition(position).toString()
                when (currentType) {
                    "Lorem Ipsum" -> {
                        binding.titleText.text = loremIpsum.type
                        binding.loremText.text = loremIpsum.content
                    }
                    "Cupcake Ipsum" -> {
                        binding.titleText.text = cupcakeIpsum.type
                        binding.loremText.text = cupcakeIpsum.content
                    }
                    "Bacon Ipsum" -> {
                        binding.titleText.text = baconIpsum.type
                        binding.loremText.text = baconIpsum.content
                    }
                    "Veggie Ipsum" -> {
                        binding.titleText.text = veggieIpsum.type
                        binding.loremText.text = veggieIpsum.content
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Log.d("LoremGenerator :: ","onNothingSelected() is Called! Doing Absolutely Nothing....")
            }

        }

        binding.creatorButton.setOnClickListener {
            pickCreatorName(binding.creatorButton)
        }
        binding.creatorText.setOnClickListener {
            changeCreatorName(it)
        }
    }

    private fun pickCreatorName(view: View) {
        binding.apply {
            creatorText.text = "by " + creatorFill.text.toString()
            creatorFill.visibility = View.GONE
            view.visibility = View.GONE
            loremTypeSpinner.visibility = View.GONE
            creatorText.visibility = View.VISIBLE
        }

        val tip = Toast.makeText(this, "Tap your name to change settings", Toast.LENGTH_SHORT)
        tip.setGravity(Gravity.CENTER, 0, -300)
        tip.show()

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun changeCreatorName(view: View) {
        binding.apply {
            view.visibility = View.GONE
            creatorFill.visibility = View.VISIBLE
            creatorButton.visibility = View.VISIBLE
            loremTypeSpinner.visibility = View.VISIBLE
            creatorFill.requestFocus()
        }

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(binding.creatorFill, 0)
    }
}
