[//]: # (# h1 Heading)
[//]: # (## h2 Heading)

[//]: # (### h3 Heading)

[//]: # (#### h4 Heading)

[//]: # (##### h5 Heading)

[//]: # (###### h6 Heading)
# Sherzod Nurboyev
biz kim mulki turon

---
## Horizontal Rules
---

___

---

***



## Emphasis

**This is bold text**

__This is bold text__

*This is italic text*

_This is italic text_

~~Strikethrough~~


## Blockquotes


> Blockquotes can also be nested...
>> ...by using additional greater-than signs right next to each other...
> > > ...or with spaces between arrows.
> > > > ...or with spaces between arrows.
> > > > > ...or with spaces between arrows.
> > > > > > ...or with spaces between arrows.


## Lists

Unordered

* asdasdasd
* asdsad
  * sdfdsfdsf
  * sdfsdfds
  + asdsadsad
  + asdas
  + dsad
  + sads
  + ad
* sad
* sa
* das
* das
* d
* sa

Ordered

1. Lorem ipsum dolor sit amet
2. Consectetur adipiscing elit
3. Integer molestie lorem at massa


1. You can use sequential numbers...
1. ...or keep all the numbers as `1.`

Start numbering with offset:

57. foo
1. bar



Lorem Ipsum is simply dummy text of the `printing` and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.
Why do we use it?

It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).

## Code

    hashdasd

Inline `code`

Indented code

    // Some comments
    line 1 of code
    line 2 of code
    line 3 of code


Block code "fences"

```java
package tgbotg42;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import tgbotg42.exception.TelegramException;
import tgbotg42.types.SendMessage;
import tgbotg42.types.common.Message;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class TelegramBot {
    private final String token;
    private final HttpClient httpClient;
    private final String url;
    private final Gson gson;

    public TelegramBot(String token) {
        this.token = token;
        this.httpClient = HttpClient.newHttpClient();
        this.url = "https://api.telegram.org/bot" + token;
        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }


    public Message sendMessage(SendMessage message) throws TelegramException {
        try {
            HttpRequest sendMessageRequest = HttpRequest.newBuilder()
                    .uri(URI.create(url + "/sendMessage"))
                    .header("Content-Type", "application/json")
                    .method("POST", HttpRequest.BodyPublishers.ofString(gson.toJson(message)))
                    .build();
            HttpResponse<String> response = httpClient.send(sendMessageRequest, HttpResponse.BodyHandlers.ofString());
            JsonObject jsonObject = gson.fromJson(response.body(), JsonObject.class);
            if (!jsonObject.get("ok").getAsBoolean()) {
                throw new TelegramException(jsonObject.get("description").getAsString());
            }
            return gson.fromJson(jsonObject, Message.class);
        } catch (IOException | InterruptedException e) {
            throw new TelegramException(e);
        }
    }

}
```

Syntax highlighting

``` js
var foo = function (bar) {
  return bar++;
};

console.log(foo(5));
```

## Tables

|  Option  | Description |
|:--------:| ----------- |
|   data   | path to data files to supply the data that will be passed into templates. |
|  engine  | engine to be used for processing templates. Handlebars is the default. |
|   ext    | extension to be used for dest files. |

Right aligned columns

| Option  |                                Description                                 |
|:-------:|:--------------------------------------------------------------------------:|
|  data   | path to data files to supply the data that will be passed into templates.  |
| engine  |   engine to be used for processing templates. Handlebars is the default.   |
|   ext   |                    extension to be used for dest files.                    |


## Links

[link text](http://dev.nodeca.com)

[link with title](http://nodeca.github.io/pica/demo/ "title text!")

Autoconverted link https://github.com/nodeca/pica (enable linkify to see)


## Images

![Minion](https://octodex.github.com/images/minion.png)
![Stormtroopocat](https://octodex.github.com/images/stormtroopocat.jpg "The Stormtroopocat")

Like links, Images also have a footnote style syntax

![Alt text][id]

With a reference later in the document defining the URL location:

[id]: https://octodex.github.com/images/dojocat.jpg  "The Dojocat"


## Plugins

The killer feature of `markdown-it` is very effective support of
[syntax plugins](https://www.npmjs.org/browse/keyword/markdown-it-plugin).


### [Emojies](https://github.com/markdown-it/markdown-it-emoji)

> Classic markup: :wink: :cry: :laughing: :yum:
>
> Shortcuts (emoticons): :-) :-( 8-) ;)

see [how to change output](https://github.com/markdown-it/markdown-it-emoji#change-output) with twemoji.


### [Subscript](https://github.com/markdown-it/markdown-it-sub) / [Superscript](https://github.com/markdown-it/markdown-it-sup)

- 19^th^
- H~2~O


### [\<ins>](https://github.com/markdown-it/markdown-it-ins)

++Inserted text++


### [\<mark>](https://github.com/markdown-it/markdown-it-mark)

==Marked text==


### [Footnotes](https://github.com/markdown-it/markdown-it-footnote)

Footnote 1 link[^first].

Footnote 2 link[^second].

Inline footnote^[Text of inline footnote] definition.

Duplicated footnote reference[^second].

[^first]: Footnote **can have markup**

    and multiple paragraphs.

[^second]: Footnote text.


### [Definition lists](https://github.com/markdown-it/markdown-it-deflist)

Term 1

:   Definition 1
with lazy continuation.

Term 2 with *inline markup*

:   Definition 2

        { some code, part of Definition 2 }

    Third paragraph of definition 2.

_Compact style:_

Term 1
~ Definition 1

Term 2
~ Definition 2a
~ Definition 2b


### [Abbreviations](https://github.com/markdown-it/markdown-it-abbr)

This is HTML abbreviation example.

It converts "HTML", but keep intact partial entries like "xxxHTMLyyy" and so on.

*[HTML]: Hyper Text Markup Language

### [Custom containers](https://github.com/markdown-it/markdown-it-container)

::: warning
*here be dragons*
:::
